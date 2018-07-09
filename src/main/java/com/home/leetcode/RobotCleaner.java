package com.home.leetcode;

import java.util.HashSet;
import java.util.Set;

interface Robot {
	// Returns true if the cell in front is open and robot moves into the cell.
	// Returns false if the cell in front is blocked and robot stays in the current cell.
	public boolean move();

	// Robot will stay in the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	public void turnLeft();
	public void turnRight();

	// Clean the current cell.
	public void clean();
}

class RobotImpl implements Robot{
	// Returns true if the cell in front is open and robot moves into the cell.
	// Returns false if the cell in front is blocked and robot stays in the current cell.
	int x=1, y=3;
	int dir=1;
	public boolean move() {
		//go up
		if(dir==1) {
			if(x>0) {
				x--; return true;
			}
			else return false; 
		}
		
		//go left
		if(dir==2) {
			if(y>0) {
				y--; return true;
			}
			else return false; 
		}
		
		//go down
		if(dir==3) {
			if(x<4) {
				x++; return true;
			}
			else return false; 
		}
		
		//go right
		if(dir==4) {
			if(y<7) {
				y++; return true;
			}
			else return false; 
		}
		
		return false;
	}

	// Robot will stay in the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	public void turnLeft() {
		//1,2,3,4,1,2,3,4
		dir=(dir+1)%5;
		if(dir==0) dir++;
	}
	public void turnRight() {
		//4,3,2,1,4,3,2,1
		if (dir-1==0) {
			dir=4;
		} else {
			dir--;
		}
	}

	// Clean the current cell.
	public void clean() {
		RobotCleaner.room[x][y]=2;
	}
}

/**
 
 Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3
 
 
 * @author kshitij
 *
 */

public class RobotCleaner {

	private static int[][] directions;
	static {
        directions = new int[][] {
        	{-1, 0},
        	{0, -1},
        	{1, 0},
            {0, 1}
        };
    }
	
	public static int[][] room = {
	                              {1,1,1,1,1,0,1,1},
	                              {1,1,1,1,1,0,1,1},
	                              {1,0,1,1,1,1,1,1},
	                              {0,0,0,1,0,0,0,0},
	                              {1,1,1,1,1,1,1,1}
};
	
	public static void main(String...visited) {
		new RobotCleaner().cleanRoom(new RobotImpl());
	}
	
	public void cleanRoom(Robot robot) {
		Set<String> visited = new HashSet<>();
		cleanRoomHelper(robot, 1, 3, visited, 0);
		System.out.println(room);
	}
	
	public void cleanRoomHelper(Robot robot, int x, int y, Set<String> visited, int direction) {
		if (room[x][y]!=0 && !visited.contains(x+"#"+y)) {
			visited.add(x+"#"+y);
			robot.clean();
			
			for (int i=0; i<4; i++) {
				int dir = (direction+i)%4;
				if (robot.move()) {
					cleanRoomHelper(robot, x+directions[dir][0], y+directions[dir][1], visited, dir);
				}
				robot.turnLeft();
			}
			
			//Turn right
			robot.turnRight();
			robot.move();
			//Bring robot's state back. 
			robot.turnRight();robot.turnRight();
			
		}
	}
}
