/*
Insertion	O(n)
Deletion	O(n)
Maximum		O(n)
Minimum		O(n)
Rotation	O(n)
Selection	O(n) expected if randomised pivot is used otherwise O(n^2)
Sorting		O(n*log n)
*/
import java.io.*;
import java.util.LinkedHashSet;

public class DynamicArray<type extends Comparable <type> >{
	private static Comparable a[];
	private static int end;
	private static int capacity;
	
	public static class Quick{
		private static int partition(int lo, int hi){
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
		
		private static void sort(int lo, int hi) { 
	        	if (hi <= lo) return;
		        int j = partition(lo, hi);
		        sort( lo, j-1);
	        	sort( j+1, hi);
		}
		
		//Quick-Sort
		public static void sort() {
	        	sort(0, end - 1);
	        }

		//Quick-Select
		public static Comparable select(int k){
			int lo = 0, hi = end-1;
			while(hi>lo){
				int j = partition(lo, hi);
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
	}
	
	//insert at end
	public static void pushBack(Comparable data){
		if(end < capacity)
			a[end++] = data;
		else{
			capacity*=1.5;
			Comparable b[] = new Comparable[capacity];
			System.arraycopy(b, 0, a, 0, a.length);
			a=b;
		}
	}
	
	//Insertion
	public static void insert(int pos, Comparable data){
		if(end>=a.length){
			capacity*=1.5;
			Comparable b[] = new Comparable[capacity];
			System.arraycopy(b, 0, a, 0, a.length);
			a=b;
		}
		Comparable prev = a[pos];
        	a[pos] = data;
	        for(int i =pos ;i<end;i++){
        		Comparable next = a[i+1];
        		a[i+1] = prev;
	        	prev = next;
	        }
	        end++;
	}
	
	//Deletion
	public static void delete(int pos){
		if (end==0){
			System.out.println("UNDERFLOW");
			return;
		}
		for(int i =pos ;i<end-1;i++)
        		a[i]= a[i+1];
	        end--;
	}
	
	//Sorting
	public static void sort(){
		Quick.sort();
	}
	
	//Selection
	public static Comparable select(int k){
		return Quick.select(k);
	}
	
	//Maximum
	public static Comparable max(){
		if (a == null || a.length == 0)
            		return null;
	        Comparable mx = a[0];
	        for (int i = 1; i < a.length; i++)
	            if (mx.compareTo(a[i]) < 0)
        	        mx = a[i];
	        return mx;
	}
	
	//Minimum
	public static Comparable min(){
		if (a == null || a.length == 0)
	            return null;
	        Comparable mn = a[0];
        	for (int i = 1; i < a.length; i++)
	            if (mn.compareTo(a[i]) > 0)
        	        mn = a[i];
	        return mn;
	}
	
	//Rotation
	public static void leftRotate(int d){
		Comparable b[] = a.clone();
		int remain=0;
		if(d>end){
			int comp = d/end;
			remain = d - end*comp; 
		}
		for(int i=0; i<end; i++)
			b[(i+end-remain)%end] = a[i];
		a=b;
	}
	public static void rightRotate(int d){
		Comparable b[] = a.clone();
		for(int i=0; i<end; i++)
			b[(i+end+d)%end] = a[i];
		a=b;
	}

	//Is Unique
	public static boolean isUnique(){
		LinkedHashSet<Comparable> hs = new LinkedHashSet<Comparable>();
		for(int i=0;i<end;i++){
			if(hs.contains(a[i]))
				return false;
			else
				hs.add(a[i]);
		}
		return true;
	}
	
	//Print
	public static void print(){
		for(int i=0;i<end;i++)
	        	System.out.print(a[i]+ " ");
		System.out.println();
	}
	public static void printRev(){
		for(int i=end-1;i>=0;i--)
	        	System.out.print(a[i]+ " ");
		System.out.println();
	}
	public static void printDistinct(){
		LinkedHashSet<Comparable> hs = new LinkedHashSet<Comparable>();
		for(int i=0;i<end;i++)
			hs.add(a[i]);
		for(Comparable x: hs)
			System.out.print(x+" ");
		System.out.println();
	}
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		System.out.println("Enter size");
	        int size =capacity= Integer.parseInt( br.readLine());
        	a = new Integer[size];
        
        	//Input in array
	        System.out.println("Enter num of ints");
        	end = Integer.parseInt( br.readLine());
	        System.out.println("Enter ints");
        	String in[]= br.readLine().split(" ");
	        for(int i=0;i<end;i++)
        		a[i] = Integer.parseInt(in[i]);
       
	        //Insertion
		System.out.println("Enter index for insertion");
        	int pos = Integer.parseInt( br.readLine());
	        System.out.println("Enter data");
        	int data = Integer.parseInt( br.readLine());
	        insert(pos, data);
        	print();
	       
        	//Deletion
		System.out.println("Enter index for deletion");
	        pos = Integer.parseInt( br.readLine());
        	delete(pos);
	        print();
                
		 //Find Min-Max
	        System.out.println("Minimum "+min());
	        System.out.println("Maximum "+max());
              
	        //Find Median
	        System.out.println("Median "+select(end/2));
	        
	        //sorting
	        sort();
	        print();
	        printRev();

		//Rotation
	        leftRotate(10);
	        print();
	        rightRotate(11);
	        print();
	     
	        System.out.println("IsUnique "+isUnique());
	        System.out.print("Distinct ");
	        printDistinct();
    	}
}