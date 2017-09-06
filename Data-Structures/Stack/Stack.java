import java.util.Iterator;
public class  Stack<Item> implements Iterable<Item>{
	private Node first = null;
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
	public void  push(Item item){
		Node oldStack = first;
		first = new Node();
		first.data = item;
		first.next = oldStack;
	}
	public Item pop(){
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
		 Stack<Integer> stack = new Stack<Integer>();
		 stack.push(1);
		 System.out.println(stack.pop());
		 System.out.println(stack.isEmpty());
		 */
	 }
}