package com.home.heap;

import java.awt.HeadlessException;

public class MyHeap {

	int[] arr = new int[5];
	public static void main(String[] args) {
		MyHeap obj = new MyHeap();
		obj.arr[0] = 1;
		obj.arr[1] = 2;
		obj.arr[2] = 3;
		obj.arr[3] = 4;
		obj.arr[4] = 5;
		
		System.out.print("Input - ");
		for (int i=0; i<obj.arr.length; i++) {
			System.out.print(obj.arr[i] + " ");
		}
		System.out.print("\nHeapified array - ");
		
		// Build Heap
		obj.buildHeap();
		
		for (int i=0; i<obj.arr.length; i++) {
			System.out.print(obj.arr[i] + " ");
		}
		
		System.out.print("\nHeapsorted array - ");
		obj.heapSort();
		for (int i=0; i<obj.arr.length; i++) {
			System.out.print(obj.arr[i] + " ");
		}

	}

	private void buildHeap() {
		int len = (arr.length)/2;
		while (len>=0) {
			maxHeapify(len, arr.length);
			len--;
		}
	}
	
	private void maxHeapify(int i, int arrLength) {
		int left = 2*i+1;
		int right = 2*i+2;
		
		int largest=-1;
		if (left<arrLength && arr[left]>arr[i]) {
			largest = left;
		} else {
			largest = i;
		}
		
		if (right<arrLength && arr[right]>arr[largest]) {
			largest = right;
		}
		
		if (largest!=i) {
			// swap the elements and recurse on largest.
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			maxHeapify(largest, arrLength);
		}
	}
	
	private void heapSort() {
		int len = arr.length;
		while (len>0) {
			int temp = arr[0];
			arr[0] = arr[len-1];
			arr[len-1] = temp;
			len--;
			maxHeapify(0, len);
		}
	}

}
