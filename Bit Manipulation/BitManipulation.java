public class BitManipulation{
	public int add(int set, int position){
		return set|= (1<<position);
	}
	
	public void printItemsOfSet(int set){
		for(int i=0;i<32;i++){
	    	if(((set >> i) & 1)!=0)
	    		System.out.print(i+"\t");
	    }
		System.out.println();
	}
	
	public int union(int set1, int set2){
		return set1|set2;
	}
	
	public int intersection(int set1, int set2){
		return set1&set2;
	}
	
	public void complements(int set){
		int n = ~set & ((1<<30)-1);
		for(int i=0;i<32;i++){
	    	if ( ((n >> i) & 1)!=0 )
	    		System.out.print(i+"\t");
		}
		System.out.println();
	}
	
	public boolean check(int set, int position){
		if((set & (1<<position))!=0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args){
		BitManipulation obj = new BitManipulation();
		
		int setA = obj.add(0,0);
		setA = obj.add(setA, 4);
		setA = obj.add(setA, 8);
		
		int setB = obj.add(0, 12);
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