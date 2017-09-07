/*
Number of Comparisons: ( n*(n-1) )/2  -> O(n^2)
Number of Exchanges:    n             -> O(n) Data Movement is minimal  
Time Complexity:		O(n^2) insensitive to input
Space Complexity:       O(1)   
*/
class SelectionSort{
	public static void sort(Comparable[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int min = i;
			for(int j=i+1;j<n;j++){
				if(less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	private static void exch(Comparable a[], int i, int j){
		Comparable swap = a[i];
        	a[i] = a[j];
	        a[j] = swap;
	}
	public static void main(String[] args){
		Integer a[] = {11,7,4,2,8};
		SelectionSort.sort(a);
		for(Integer x : a)System.out.println(x);
	}
}