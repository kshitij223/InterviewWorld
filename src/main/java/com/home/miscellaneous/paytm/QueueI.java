package com.home.miscellaneous.paytm;

public interface QueueI<T> {
    public QueueI<T> enQueue(T t);
    
    //Removes the element at the beginning of the immutable queue, and returns the new queue.
    public QueueI<T> deQueue();
    public T head();
    public boolean isEmpty();
}