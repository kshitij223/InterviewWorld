package com.home.array;

public class CircularQueue {

	static int front=0, rear=0;
	private static final int MAX_SIZE = 4;
	public static void enqueue(int[] arr, int value) throws Exception {
		rear = (1+rear)%MAX_SIZE;
		if (rear == front) {
			throw new Exception("queue is full");
		}
		else {
			arr[rear] = value;
		}
	}
	
	public static void dequeue(int[] arr) throws Exception {
		if (rear == front) {
			throw new Exception("queue is empty");
		}
		else {
			front = (1+front)%MAX_SIZE;
		}
	}
	
	public static void display(int[] arr) {
		for (int i = 0; i<MAX_SIZE; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] arr = new int[MAX_SIZE];
		enqueue(arr, 2);
//		enqueue(arr, 3);
//		dequeue(arr);
//		enqueue(arr, 5);
//		enqueue(arr, 6);
		display(arr);

	}

}
