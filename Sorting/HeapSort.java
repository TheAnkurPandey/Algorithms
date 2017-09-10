class HeapSort{
	
	private static void sink(Comparable[] pq, int parent, int size){
		int l=2*parent+1, r=2*parent+2,largest;
		
		if(l<size && less(pq[parent],pq[l])){
			largest=l;
		}else{
			largest=parent;
		}
		
		if(r<size && less(pq[largest],pq[r])){
			largest=r;
		}
		
		if(largest!=parent){
			swap(pq, parent,largest);
			sink(pq, largest, size);
		}	
	}

	private static void sort(Comparable[] pq){
		
		int size=pq.length;
		for(int i=size/2-1;i>=0;i--){
			sink(pq, i, size);
		}
		
		int i=pq.length-1;
		while(i>=0){
			swap(pq,0,i--);
			sink(pq, 0, --size);
		}
	}

	private static boolean less(Comparable v, Comparable w) {
        	return v.compareTo(w) < 0;
    	}
        
    	private static void swap(Comparable[] pq, int i, int j) {
        	Comparable temp = pq[i];
	        pq[i] = pq[j];
	        pq[j] = temp;
 	}
    
	private static void print(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+"\t");
		System.out.println();
	}

	public static void main(String[] args){
		String a[] = {"za","h","ib", "ia","b", "yc","yb","e"};
		HeapSort.sort(a);
		print(a);
	}
}