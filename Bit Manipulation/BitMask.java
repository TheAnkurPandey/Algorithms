public class BitMask{
	public long add(long set, int position){
		return set|=(1L<<position);
	}
	
	public void printItemsOfSet(long set){
		for(int i=0;i<64;i++){
	    		if(((set >> i) & 1)!=0)
	    			System.out.print(i+"\t");
		}
		System.out.println();
	}
	
	public long union(long set1, long set2){
		return set1|set2;
	}
	
	public long intersection(long set1, long set2){
		return set1&set2;
	}
	
	public void complements(long set){
		long n = ~set & ((1L<<63)-1);
		for(int i=0;i<64;i++){
	    		if ( ((n >> i) & 1)!=0 )
	    			System.out.print(i+"\t");
		}
		System.out.println();
	}
	
	public boolean check(long set, int position){
		if((set & (1L<<position))!=0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args){
		BitMask obj = new BitMask();
		
		long setA = obj.add(0,0);
		setA = obj.add(setA, 4);
		setA = obj.add(setA, 8);
		
		long setB = obj.add(0, 12);
		setB = obj.add(setB, 16);
		setB = obj.add(setB, 20);
		setB = obj.add(setB, 8);
		
		obj.printItemsOfSet(setA);
		obj.printItemsOfSet(setB);
		
		obj.printItemsOfSet(obj.union(setA, setB));
		obj.printItemsOfSet(obj.intersection(setA, setB));
		
		obj.complements(obj.union(setA, setB));
		System.out.println(obj.check(setA,8));
    }
}