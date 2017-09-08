/*
Optimisation
1-Use insertion sort for small aubarray
2-Stop if already sorted
3-Eliminate the copy to auxilary array
*/
public class OptimisedMergeSort{
	private static final int CUTOFF = 7;
	private static void merge(Comparable[] a, Comparable[] aux, int lo,int mid,int hi){
		
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++){
			if(i>mid) aux[k] = a[j++];
			else if(j>hi) aux[k] = a[i++];
			else if(less(a[i],a[j])) aux[k] = a[i++];
			else aux[k] = aux[j++];
		}
	}

	private static void sort(Comparable[] a,Comparable[] aux, int lo, int hi){
		if (hi <= lo + CUTOFF) { 
            insertionSort(aux, lo, hi);
            return;
        }
		int mid = lo + (hi-lo)/2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid+1, hi);
		if (less(a[mid], a[mid+1])) {
            for (int i = lo; i <= hi; i++) aux[i] = a[i];
            return;
        }
		merge(a, aux, lo, mid, hi);
	}

	private static void sort(Comparable[] a){
		Comparable[] aux = a.clone();
		sort(aux, a, 0, a.length-1);
	}
	
	 private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                swap(a, j, j-1);
    }
	
	private static boolean less(Comparable v, Comparable w){
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
		Integer a[] = {11,7,4,2,8};
		OptimisedMergeSort.sort(a);
		print(a);
	}
}