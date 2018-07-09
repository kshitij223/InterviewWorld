package com.home.miscellaneous.paytm;

import java.util.NoSuchElementException;

/**
 * Queue would keep reference of two Stacks, one for enqueue and other for dequeue
 * 
 * To keep immutability, just like stack we would return a new instance
 * of Queue every time the caller tries to enqueue a new element.
 * 
 * When we enqueue, we would push the element on inbound stack, (Complexity O(1))
 * when we dequeue, we would pop the top element from the outbound stack,
 * In case the outbound stack is empty, we would rollover the inbound over to outbound for that Queue instnace.
 * For dequeue average/amortized complexity would be O(1) for stack shuffeling would be a one off occurrence
 * 
 * 
 * @author kshitij
 *
 * @param <T>
 */
public class QueueImpl<T> implements QueueI<T> {
	
	private Stack<T> inbound = null;
	private Stack<T> outbound = null;
	
	public QueueImpl(){
		this.inbound = new Stack<T>();
		this.outbound = new Stack<T>();
	}
	/**
	 * Using two immutable stack order and reverse
	 */
	public QueueImpl(Stack<T> order,Stack<T> reverse){
		this.inbound = order;
		this.outbound = reverse;
	}
	
	/**
	 * Switch the order of stacks.
	 * Reverse is assigned order, and order is reinitialized 
	 */	
	private void balanceQueue(){
		this.outbound= this.inbound.flipStack();
		this.inbound = new Stack<T>();
	}
	
	/**
	 * Enqueues the element to the queue and returns 
	 */
	@Override
	public QueueI<T> enQueue(Object object) {
		if(object==null)
			throw new IllegalArgumentException();
		return new QueueImpl<T>(this.inbound.push((T)object),this.outbound);
	}

	/**
	 * This would extract the top element in outbound stack, if one is present
	 * If not, then flip the inbound stack and move elements to outbound stack.
	 */
	@Override
	public QueueI<T> deQueue(){
		if(this.isEmpty()) throw new NoSuchElementException();
		
		if(!this.outbound.isEmpty()){
			return new QueueImpl<T>(this.inbound,this.outbound.getTail());
		} else {
			// outbound stack is empty. Move all inbound elements over to outbound
			// To remove the element, just refer to the tail element.
			return new QueueImpl<T>(new Stack<T>(), this.inbound.flipStack().getTail());
		}		
	}
	
	
	@Override
	public boolean isEmpty(){
		int size =  this.inbound.getSize() + this.outbound.getSize();
		return size==0?true:false;
	}
	
	@Override
	public T head() {
		if(this.isEmpty()) throw new NoSuchElementException();
		
		if(this.outbound.isEmpty()) {
			balanceQueue();
		} 
		return this.outbound.getData();
	}
	
}