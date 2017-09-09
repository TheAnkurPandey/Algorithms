public class QuickSelect{
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo, j = hi+1;
		while(true){
			while(less(a[++i],a[lo])&&(i!=hi));
				
			while(less(a[lo],a[--j])&&(j!=lo));
				
			if(i>=j) break;
			swap(a, i, j);
		} 
		swap(a, lo, j); 
		return j;	
	}
	
	public static Comparable select(Comparable[] a, int k){
		int lo = 0, hi = a.length-1;
		while(hi>lo){
			int j = partition(a, lo, hi);
			if(j<k) lo = j+1;
			else if(j>k) hi = j-1;
			else return a[k];
		}
		return a[k];
	}

	private static boolean less(Comparable v, Comparable w) {
        	return v.compareTo(w) < 0;
    	}
        
    	private static void swap(Comparable[] a, int i, int j) {
        	Comparable temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
 	}	

	public static void main(String[] args){
		Integer a[] = {11,7,4,2,8,0,67,45,53,21};
		System.out.println(QuickSelect.select(a,5));
	}
}