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
	
	public MinBinaryHeap(int capacity){
		pq = (Key[]) new Comparable[capacity+1];
		System.out.println(pq.length);
		n = 0;
	}

	public boolean isEmpty(){
		return n == 0;
	}
	public void insert(Key x){
		pq[++n] = x;
		swim(n);
	}
	public Key delMin(){
		Key max = pq[1];
		swap(1,n--);
		sink(1);
		pq[n+1] = null;
		return max;
	}
	
	private void swim(int k){
		while(k>1 && greater(pq[k/2],pq[k])){
			swap(k,k/2);
			k=k/2;
		}
	}
	private void sink(int parent){
		int l=2*parent, r=2*parent+1,smallest;
		
		if(l<=n && greater(pq[parent],pq[l])){
			smallest=l;
		}else{
			smallest=parent;
		}
		
		if(r<=n && greater(pq[smallest],pq[r])){
			smallest=r;
		}
		if(smallest!=parent){
			swap(parent,smallest);
			sink(smallest);
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
		return n;
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