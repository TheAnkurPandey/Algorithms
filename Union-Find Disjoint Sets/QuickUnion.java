/*
Quick-Union
Initialisation: O(N)
Find: O(N)  
Union: O(N) takes constant if given the root
for M union-find operation on N objects running time is O(N*M) 
Find is too expensive because it takes time proportional to depth of p and q
*/

class QuickUnion{
	private int []id;
	
	public QuickUnion(int N){
		id=new int[N];
		for(int i=0;i<id.length;i++) id[i]=i;
	}
	
	//chase the parent pointer until you reach the root
	private int root(int j){
		while(j!=id[j]) j=id[j];
		return j;
	}
	
	//check if p and q have same root
	public boolean isConnected(int p,int q) {return root(p)==root(q);}	
	
	//set p's root to q's root 
	public void union(int p,int q){
		int proot = root(p);
		int qroot = root(q);
		id[proot] = qroot;
	}
	
	void print(){
		for(int i =0;i<id.length;i++) System.out.print(id[i]+"\t");
	}
	public static void main(String[] args){
		 /*
		 QuickUnion qu = new QuickUnion(5);
		 qu.union(0,1);
		 System.out.println(qu.isConnected(1,0));
		 System.out.println(qu.isConnected(3,0));
		 qu.print();
		 */
		 
	}
}