/*
Time Complexity:	O(nlogn)
Space Complexity:	O(n)	
Stable
Not In-Place
*/
public class MergeSort{
	private static void merge(Comparable[] a, Comparable[] aux, int lo,int mid,int hi){
		for(int k=lo;k<=hi;k++) aux[k] = a[k];
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(less(aux[i],aux[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}

	private static void sort(Comparable[] a,Comparable[] aux, int lo, int hi){
		if(hi<=lo) return;
		int mid = lo + (hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1);
	}

	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+"\t");
	}

	public static void main(String[] args){
		Integer a[] = {11,7,4,2,8};
		MergeSort.sort(a);
		show(a);
	}
}
