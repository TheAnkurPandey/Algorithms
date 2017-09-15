/*
Application of Minimum Binary Heap
Find the largest m item in stream of n items 
Time Complexity:	O(nLogm)
Space Complexity:	O(m)
*/
import java.io.*;
public class MinBinaryHeap<Key extends Comparable<Key>>{

	private Key[] pq;
	private int n;
	
	public hi(int capacity){
		pq = (Key[]) new Comparable[capacity];
		n = -1;
	}

	public boolean isEmpty(){
		return n == -1;
	}
	public void insert(Key x){
		pq[++n] = x;
		swim(n);
	}
	public Key delMin(){
		Key max = pq[0];
		swap(0,n--);
		sink(0);
		pq[n+1] = null;
		return max;
	}
	
	private void swim(int k){
		while(k>0 && greater(pq[k/2],pq[k])){
			swap(k,k/2);
			k=k/2;
		}
	}
	private void sink(int parent){
		int l=2*parent+1, r=2*parent+2,largest;
		
		if(l<n && greater(pq[parent],pq[l])){
			largest=l;
		}else{
			largest=parent;
		}
		
		if(r<n && greater(pq[largest],pq[r])){
			largest=r;
		}
		
		if(largest!=parent){
			swap(parent,largest);
			sink(largest);
		}	
	}
	private boolean greater(Comparable left, Comparable right) {
        	return left.compareTo(right) > 0;
        }
        
    	private void swap(int i, int j) {
        	Key temp = pq[i];
	        pq[i] = pq[j];
	        pq[j] = temp;
 	}
    	
	public void print() {
		for (int i = 0; i <= n; i++)
			System.out.print(pq[i]+"\t");
		System.out.println();
	}
	public int size() {
		return n+1;
	}

	public static void main(String[] args)throws IOException{
		int m;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	System.out.println("Enter integers");
	        String data[] = br.readLine().split(" ");
	        m = Integer.parseInt(data[0]);
	        MinBinaryHeap<Integer> bh = new MinBinaryHeap<Integer>(m+1);
	        for(int i=1;i<data.length;i++){
        		bh.insert(Integer.parseInt(data[i]));
        		if(bh.size()>m)
	        		bh.delMin();
        	}
	        bh.print();
        }
		
}