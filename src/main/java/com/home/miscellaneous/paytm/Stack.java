package com.home.miscellaneous.paytm;

/**
 * To keep stack immutable, each element of the stack is a new object
 * Whenever we push an element onto the stack we create a new 
 * stack object, with the head containing that element
 * 
 * This way each caller would work independent of simultaneous stack access.
 * 
 * @author kshitij
 *
 * @param <T>
 */
public class Stack<T> {
	
	private T data;
	private Stack<T> tail;
	private int size;
	
	public Stack(){
		this.setData(null);
		this.setTail(null);
		this.setSize(0);
	}
	
	private Stack(T obj,Stack<T> tail){
		this.setData(obj);
		this.setTail(tail);
		this.setSize(tail.getSize()+1);
	}

	public Stack<T> getTail() {
		return tail;
	}


	public void setTail(Stack<T> tail) {
		this.tail = tail;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public int getSize() {
		return size;
	}


	private void setSize(int size) {
		this.size = size;
	}
	
	public boolean isEmpty(){
		return this.getSize() ==0;
	}
	
	public Stack<T> push(T obj){
		return new Stack<>(obj, this);
	}
	
	/**
	 * When the outbound stack is empty, we need to use this method
	 * to pop and then push all elements from inbound over to outbound
	 * @return
	 */
	public Stack<T> flipStack(){
		Stack<T> stack = new Stack<T>();
		Stack<T> tail = this;
		while(!tail.isEmpty()){
			stack = stack.push(tail.getData());
			tail = tail.getTail();
		}
		return stack;
	}
	
}
