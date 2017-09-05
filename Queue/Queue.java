import java.util.Iterator;
public class  Queue<Item> implements Iterable<Item>{
	private Node first = null;
	private Node last = null;
	private class Node{
		Item data;
		Node next;
	}
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){
			return current!=null;
		}
		public Item next(){
			Item item = current.data;
			current = current.next;
			return item;
		}
	}
	public void  enqueue(Item item){
		Node oldQueue = last;
		last = new Node();
		last.data = item;
		last.next = null;
		if(isEmpty())
			first = last;
		else 
			oldQueue.next = last;
	}
	public Item dequeue(){
		if(isEmpty()){
			Item message = (Item)"UNDERFLOW";
			return message;
		}
		Item top = first.data;
		first = first.next;
		return top;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public static void main(String[] args){
		 /*
		 Queue<Integer> queue = new Queue<Integer>();
		 queue.enqueue(1);
		 System.out.println(queue.isEmpty());
		 System.out.println(queue.dequeue());
	     	 System.out.println(queue.isEmpty());
		 */
	 }
}