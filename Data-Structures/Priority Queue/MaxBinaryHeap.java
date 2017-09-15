/*
Insert:		O(Logn)
Delete Max:	O(Logn)
max:		O(1)
*/
public class MaxBinaryHeap<Key extends Comparable<Key>>{

	private Key[] pq;
	private int n;
	
	public MaxBinaryHeap(int capacity){
		pq = (Key[]) new Comparable[capacity+1];
		n = 0;
	}

	public boolean isEmpty(){
		return n == 0;
	}
	public void insert(Key x){
		pq[++n] = x;
		swim(n);
	}
	public Key delMax(){
		Key max = pq[1];
		swap(1,n--);
		sink(1);
		pq[n+1] = null;
		return max;
	}
	
	private void swim(int k){
		while(k>1 && less(pq[k/2],pq[k])){
			swap(k,k/2);
			k=k/2;
		}
	}
	private void sink(int parent){
		int l=2*parent, r=2*parent+1,largest;
		
		if(l<=n && less(pq[parent],pq[l])){
			largest=l;
		}else{
			largest=parent;
		}
		
		if(r<=n && less(pq[largest],pq[r])){
			largest=r;
		}
		
		if(largest!=parent){
			swap(parent,largest);
			sink(largest);
		}	
	}
	private boolean less(Comparable left, Comparable right) {
        	return left.compareTo(right) < 0;
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

	public static void main(String[] args){
		MaxBinaryHeap<Integer> bh = new MaxBinaryHeap<Integer>(6);
		bh.insert(1);
		bh.insert(6);
		bh.print();
		System.out.println(bh.delMax());
		System.out.println(bh.delMax());
		bh.print();
		System.out.println(bh.isEmpty());
	}
		
}