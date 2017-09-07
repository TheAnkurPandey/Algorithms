/*
Increment sequence Used: Knuth 3*X+1 increment sequence
Time Complexity:		 O( n^(3/2) )  If above increment sequence is used
Space Complexity:        O(1) 		
Space Complexity:
Equivalent to:           Insertion sort with stride length h
Why Insertion Sort?      Insertion sort of partial sorted array(generated after h-sorting) is linear in time.               
*/
public class ShellSort{

    public static void sort(Comparable[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < n/3) h = 3*h + 1; 

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++)
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            
            h /= 3;
        }
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }	
    public static void main(String[] args){
		Integer a[] = {11,7,4,2,8};
		ShellSort.sort(a);
		show(a);
    }

}	