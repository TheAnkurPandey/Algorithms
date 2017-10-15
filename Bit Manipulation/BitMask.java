public class BitMask{
	//Add item in a set
	public long add(long set, int position){ return set|=(1L<<position); }
	
	//Fill the set completely of size n
	public long fill(int size){ return (1 << size) - 1; }
	
	//Remove item in a set
	public long del(long set, int position){ return set&(~(1 << position));	}
	
	//Print all items in a set
	public void printSet(long set){
		for(int i=0;i<64;i++){
	    		if(((set >> i) & 1)!=0)
	    			System.out.print(i+"\t");
		}
		System.out.println();
	}
	
	//Union of 2 sets
	public long union(long set1, long set2){ return set1|set2; }
	
	//Intersection of 2 sets
	public long intersection(long set1, long set2){ return set1&set2; }
	
	//Print all items not in a set
	public void complements(long set){
		long n = ~set & ((1L<<63)-1);
		for(int i=0;i<64;i++){
	    		if ( ((n >> i) & 1)!=0 )
	    			System.out.print(i+"\t");
			}
		System.out.println();
	}
	
	//Check if item is in a set
	public boolean contains(long set, int position){
		if((set & (1L<<position))!=0)
			return true;
		else
			return false;
	}
	
	//Toggle the contains status of item at the given position
	public long toggle(long set, int position){ return set^(1L << position); }
	
	//Print smallest value of position at which item is present
	public long minSetIndx(long set){ return (set & (-set)); }
	
	//Remove item from smallest value of position in the set
	public long delAtMinSetIndx(long S) { return ((S) & (S - 1)); }
	
	//Add item at first vacant position
    	public long addAtMinResetIndx(long S) { return ((S) | (S + 1)); }

	public static void main(String[] args){
		BitMask obj = new BitMask();
		
		long setA = obj.add(0,0);
		setA = obj.add(setA, 4);
		setA = obj.add(setA, 8);
		
		long setB = obj.add(0, 12);
		setB = obj.add(setB, 16);
		setB = obj.add(setB, 20);
		setB = obj.add(setB, 8);
		
		obj.printSet(setA);
		obj.printSet(setB);
		
		long unionSet = obj.union(setA, setB);
		obj.printSet(unionSet);
		long intersectionSet = obj.intersection(setA, setB);
		obj.printSet(intersectionSet);
		
		obj.complements(unionSet);
		System.out.println(obj.contains(setA,8));
		
		//Remove the 16th item 
		long tempSet = obj.union(setA, setB);
		int position = 16;
		tempSet &= ~(1 << position);
		obj.printSet(tempSet);
		
		//Alternative way
		obj.printSet(obj.del(unionSet, 16));
		
		obj.printSet(obj.toggle(unionSet, 24));
		
		//Print lowest set bit
		obj.printSet(obj.minSetIndx(unionSet));
		
		obj.printSet(obj.fill(5));
		
		obj.printSet(obj.delAtMinSetIndx(unionSet));
		
		obj.printSet(obj.addAtMinResetIndx(unionSet));
		
	}
}