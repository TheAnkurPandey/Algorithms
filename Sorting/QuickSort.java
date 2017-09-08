/*
Quick Sort
		Comparisons	Exchanges
Worst case:	1/2*(n^2)	
Best case:	nlogn
Average case:	2(n+1)nlogn	1/3nlgn  
		~1.39nlgn (39% more compare than merge sort but faster due to less data movements)

Worst case:	sort/rev-sort/duplicates

in-palace
not stable  (long distance exchanges)
*/
public class QuickSort{
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
	
	private static void sort(Comparable[] a, int lo, int hi) { 
        	if (hi <= lo) return;
	        int j = partition(a, lo, hi);
	        sort(a, lo, j-1);
        	sort(a, j+1, hi);
	}
	
	public static void sort(Comparable[] a) {
        	sort(a, 0, a.length - 1);
        }

	private static boolean less(Comparable v, Comparable w) {
        	return v.compareTo(w) < 0;
    	}
        
    	private static void swap(Comparable[] a, int i, int j) {
        	Comparable temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
 	}
	
	private static void print(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+"\t");
	}
	
	public static void main(String[] args){
		Integer a[] = {11,7,4,2,8,0,67,45,53,21};
		QuickSort.sort(a);
		print(a);
	}
}