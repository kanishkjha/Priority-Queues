package practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinPQComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		
		if(o1<o2) {
			return -1;
		}
		else if(o1>o2){
			return 1;
		}
		return 0;
	}
	
}

class MaxPQComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		
		if(o1<o2) {
			return 1;
		}
		else if(o1>o2){
			return -1;
		}
		return 0;
	}
	
}

class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		if(o1.length()<o2.length()) {
			return 1;
		}
		else if(o1.length()>o2.length()) {
			return -1;
		}
		
		return 0;
		}
	
}

public class PriorityQueueUse {
	
	
	public static void insertIntoVirtualHeap(int[] arr, int i) {
		
		int childIndex=i;
		int parentIndex=(childIndex-1)/2;
		
		while(childIndex>0) {
			
			if(arr[childIndex]<arr[parentIndex]) {
				int temp= arr[childIndex];
				arr[childIndex]=arr[parentIndex];
				arr[parentIndex]=temp;
				childIndex=parentIndex;
				parentIndex=(childIndex-1)/2;
			}
			else {
				return;
			}
		}
	}

	private static int removeMinFromVirtualHeap(int[] arr, int heapSize) {

		int temp=arr[0];
		
		arr[0]=arr[heapSize-1];
		heapSize--;
		
		int index=0;
		int leftChildIndex=2*index+1;
		int rightChildIndex=2*index+2;
		
		while(leftChildIndex<heapSize) {
			
			int minIndex=index;
			
			if(arr[leftChildIndex]<arr[minIndex]) {
				minIndex=leftChildIndex;
			}
			
			if(rightChildIndex<heapSize && arr[rightChildIndex]<arr[minIndex]) {
				minIndex=rightChildIndex;
			}
			
			if(minIndex==index) {
				break;
			}else {
				int temp1=arr[index];
				arr[index]=arr[minIndex];
				arr[minIndex]=temp1;
				
				index=minIndex;
				leftChildIndex=2*index+1;
				rightChildIndex=2*index+2;
			}
		}
		
		return temp;
	}
	
	public static void sortKSortedArray( int[] arr, int k ) {
		
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		
		int i=0;
		
		for(; i<k; i++) {
			pq.add(arr[i]);
		}
		
		for(; i<arr.length; i++) {
			arr[i-k]=pq.remove();
			pq.add(arr[i]);
		}
		
		for(int j=arr.length-k; j<arr.length; j++) {
			arr[j]=pq.remove();
		}
	}
	
	public static void printKLargestElements(int arr[], int k) {
		
		PriorityQueue<Integer> pq= new PriorityQueue<>();

		int i=0;

		for(; i<k; i++){
			pq.add(arr[i]);
		}

		for( ; i<arr.length; i++){

			if(arr[i]>pq.peek()){
				pq.remove();
				pq.add(arr[i]);
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.print(pq.remove()+" ");
		}
	}
	
	public static void main(String[] args) {
		
		
		String arr[]= {"this", "at", "a", "their", "queues"};
		
		StringLengthComparator stringComparator= new StringLengthComparator();
		PriorityQueue<String> pq= new PriorityQueue<String>(stringComparator);
		
		for(int i=0; i<arr.length; i++) {
			pq.add(arr[i]);
		}
	
		while(!pq.isEmpty()) {
			System.out.print(pq.remove()+" ");
		}
		
//		MinPQComparator minComparator= new MinPQComparator();
//		MaxPQComparator maxComparator= new MaxPQComparator();
	
//		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(maxComparator);
//		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
		
//		int arr[]= {2,15,8,9,12,13,20};
//		
//		for(int i=0; i<arr.length; i++) {
//			pq.add(arr[i]);
//		}
//		
//		while(!pq.isEmpty()) {
//			System.out.print(pq.remove()+" ");
//		}
		
//		printKLargestElements(arr, 3);
		
//		sortKSortedArray(arr, 3);
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.print(arr[i]+" ");
//		}
		
//		int arr[]= {9,1,0,4,7,3};
//		
//		PriorityQueue<Integer> pq= new PriorityQueue<>();
//		
//		for(int i=0; i<arr.length; i++) {
//			pq.add(arr[i]);
//		}
//		
//		System.out.println(pq.element());
//		
//		while(!pq.isEmpty()) {
//			System.out.print(pq.remove()+" ");
//		}

	}

}

