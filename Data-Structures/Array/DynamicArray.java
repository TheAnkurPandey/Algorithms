/*
Insertion	O(n)
Deletion	O(n)
Maximum		O(n)
Minimum		O(n)
Rotation	O(n)
Selection	O(n) expected if randomised pivot is used otherwise O(n^2)
Sorting		O(n*log n)

add-		insert at any position
put-		Update the value at index
del-		Remove the value
get- 		get value at index
*/

import java.io.*;
import java.util.LinkedHashSet;

public class DynamicArray<type extends Comparable <type> >{
	private  type a[];
	private  int end=0;
	private  int capacity=1;
	
	public DynamicArray(int n){
		capacity = n;
		a = (type[])new Comparable[capacity];
	}
	
	private  class Quick{
		private int partition(int lo, int hi){
			int i = lo, j = hi+1;
			while(true){
				while(less(a[++i],a[lo])&&(i!=hi));
					
				while(less(a[lo],a[--j])&&(j!=lo));
					
				if(i>=j) break;
				swap(i, j);
			} 
			swap(lo, j); 
			return j;	
		}
		
		private void sort(int lo, int hi) { 
	        	if (hi <= lo) return;
		        int j = partition(lo, hi);
		        sort( lo, j-1);
	        	sort( j+1, hi);
		}
		
		//Quick-Sort
		public void sort() {
	        	sort(0, end - 1);
	        }

		//Quick-Select
		public type select(int k){
			int lo = 0, hi = end-1;
			while(hi>lo){
				int j = partition(lo, hi);
				if(j<k) lo = j+1;
				else if(j>k) hi = j-1;
				else return a[k];
			}
			return a[k];
		}

		private  boolean less(type v, type w) {
	        	return v.compareTo(w) < 0;
	    	}
	        
	    	private  void swap(int i, int j) {
	        	type temp = a[i];
		        a[i] = a[j];
		        a[j] = temp;
	 	}	
	}
	
	//insert at end
	public  void add(type data){
		if(end < capacity)
			a[end++] = data;
		else{
			capacity*=1.5;
			type b[] = (type[])new Comparable[capacity];
			for (int i = 0; i < a.length; i++)
		         b[i]=a[i];
			a=b;
		}
	}
	
	//Insertion at any position
	public  void add(int indx, type data){
		if(end>=a.length){
			capacity*=1.5;
			type b[] = (type[])new Comparable[capacity];
			for (int i = 0; i < a.length; i++)
		         b[i]=a[i];
			a=b;
		}
		type prev = a[indx];
        	a[indx] = data;
	        for(int i =indx ;i<end;i++){
        		type next = a[i+1];
        		a[i+1] = prev;
	        	prev = next;
	        }
	        end++;
	}
	
	//Update
	public  void put(int indx, type data){
		a[indx] = data;
	}
		
	//Deletion
	public void del(int pos){
		if (end==0){
			System.out.println("UNDERFLOW");
			return;
		}
		for(int i =pos ;i<end-1;i++)
        		a[i]= a[i+1];
	        end--;
	}

	//Searching
	public int find(type data){
		for(int i=0;i<end;i++){
			if(a[i].equals(data))
				return i;
		}
		return -1;
	}
	
	//Sorting
	public void sort(){
		new Quick().sort();
	}
	
	//Selection
	public type select(int k){
		return new Quick().select(k);
	}
	
	//Maximum
	public type max(){
		if (a == null || a.length == 0)
            		return null;
	        type mx = a[0];
	        for (int i = 1; i < end; i++)
	            if (mx.compareTo(a[i]) < 0)
        	        mx = a[i];
	        return mx;
	}
	
	//Minimum
	public type min(){
		if (a == null || a.length == 0)
	            return null;
	        type mn = a[0];
        	for (int i = 1; i < end; i++)
	            if (mn.compareTo(a[i]) > 0)
        	        mn = a[i];
	        return mn;
	}
	
	//Rotation
	public void leftRotate(int d){
		type b[] = a.clone();
		int remain=0;
		if(d>end){
			int comp = d/end;
			remain = d - end*comp; 
		}
		for(int i=0; i<end; i++)
			b[(i+end-remain)%end] = a[i];
		a=b;
	}
	public void rightRotate(int d){
		type b[] = a.clone();
		for(int i=0; i<end; i++)
			b[(i+end+d)%end] = a[i];
		a=b;
	}

	//Is Unique
	public boolean isUnique(){
		LinkedHashSet<type> hs = new LinkedHashSet<type>();
		for(int i=0;i<end;i++){
			if(hs.contains(a[i]))
				return false;
			else
				hs.add(a[i]);
		}
		return true;
	}
	
	//Get Capacity
	public int getCapacity(){
		return capacity;
	}
	//Get size
	public int getSize(){
		return end;
	}
	//Get value
	public type get(int indx){
		return a[indx];
	}
	
	//Print
	public void print(){
		for(int i=0;i<end;i++)
	        	System.out.print(a[i]+ " ");
		System.out.println();
	}
	public void printRev(){
		for(int i=end-1;i>=0;i--)
	        	System.out.print(a[i]+ " ");
		System.out.println();
	}
	public void printDistinct(){
		LinkedHashSet<type> hs = new LinkedHashSet<type>();
		for(int i=0;i<end;i++)
			hs.add(a[i]);
		for(type x: hs)
			System.out.print(x+" ");
		System.out.println();
	}
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Capacity");
		int arrayCapacity = Integer.parseInt( br.readLine());
		DynamicArray<Integer> da = new DynamicArray<Integer>(arrayCapacity);
		    		     
        	//Input in array
	        System.out.println("Enter num of ints");
        	int num = Integer.parseInt( br.readLine());
	        System.out.println("Enter ints");
        	String in[]= br.readLine().split(" ");
	        for(int i=0;i<num;i++)
        		da.add(Integer.parseInt(in[i]));
       
	        //Insertion
		System.out.println("Enter index for insertion");
        	int pos = Integer.parseInt( br.readLine());
	        System.out.println("Enter data");
        	int data = Integer.parseInt( br.readLine());
	        da.add(pos, data);
        	da.print();
        	
        	//Deletion
		System.out.println("Enter index for deletion");
	        pos = Integer.parseInt( br.readLine());
        	da.del(pos);
	        da.print();
                
		 //Find Min-Max
	        System.out.println("Minimum "+da.min());
	        System.out.println("Maximum "+da.max());
              
	        //Find Median
	        System.out.println("Median "+da.select(da.getSize()/2));
	        
	        //sorting
	        da.sort();
	        da.print();
	        da.printRev();

		//Rotation
	        da.leftRotate(10);
	        da.print();
	        da.rightRotate(11);
	        da.print();
	     
	        System.out.println("IsUnique "+da.isUnique());
	        System.out.print("Distinct ");
	        da.printDistinct();
    	}
}