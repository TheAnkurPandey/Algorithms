/*
			  Best-case(alredy sorted)     Worst-case(reverse sorted)				
Number of Comparisons:    n-1			       ~ n^2/2	
Number of Exchanges:      0             	       ~ n^2/2
	
Time Complexity:	O(n^2) 
Space Complexity:       O(1)   
Why Comparable? :	Goal is to sort any type of Data eg String, Integer, Double, File

For Partially sorted array insertion sorts runs linear time
*/
class InsertionSort{
	public static void sort(Comparable[] a){
		int n = a.length;
		for(int i=1;i<n;i++){
			int min = i;
			for(int j=i;j>0;j--){
				if(less(a[j], a[j-1]))
					exch(a,j,j-1);
				else
					break;
			}
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
		InsertionSort.sort(a);
		for(Integer x : a)System.out.println(x);
	}
}