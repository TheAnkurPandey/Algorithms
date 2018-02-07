import java.util.*;
import java.io.*;

public class QueueUsingCircularArray<Item> implements Iterable<Item>{
	private Item Q[];
	private int head, tail, capacity;
    
    	public hi(int capacity){
    		this.capacity = capacity;
    		Q = (Item[])new Object[capacity];
    		head = tail = 0;
    	}
	
    	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private int current = head+1;
		public boolean hasNext(){
			return current != (tail+1)%capacity;
		}
		public Item next(){
			Item item = Q[current];
			current = (++current)%capacity;
			return item;
		}
	}
    
    	public void enqueue(Item item){
    		if(isFull()){
    			System.out.println("Queue is full");
    			return;
    		}else{
    			tail = (++tail)%capacity;
    			Q[tail] = item;
    			return;
    		}
    	
    	}
    	public Item dequeue(){
    		if(isEmpty()){
    			Item message = (Item)"UNDERFLOW";
			return message;
    		}
    		
    		return Q[head = (++head)%capacity];
    	}
    
    	public boolean isEmpty(){
    		return head == tail;
    	}
    	public boolean isFull(){
    		return head == (tail + 1)%capacity;
    	}
    
    	public static void main(String args[])throws IOException{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Capacity");
		QueueUsingCircularArray<Integer> queue;
		queue = new QueueUsingCircularArray<Integer>(Integer.parseInt(br.readLine()));
		
		//Input in array
	        System.out.println("Enter num of ints");
	        int num = Integer.parseInt( br.readLine());
	        System.out.println("Enter ints");
	        String in[]= br.readLine().split(" ");
	        for(int i=0;i<num;i++)
	        	queue.enqueue(Integer.parseInt(in[i]));
		 
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
		System.out.println(queue.dequeue());
	     	System.out.println(queue.isFull());
	     	
		//Traversal
	     	for(Integer i: queue) System.out.println(i);
    	}
}