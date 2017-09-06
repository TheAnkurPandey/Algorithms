/*
Weighted Quick Union with Path Compression (Union by height/rank)
Initialisation: O(N) for Weighted Quick Union
Find: O(lg N) 	     for Weighted Quick Union
Union: O(lg N)	     for Weighted Quick Union	
For M union-find operation on N objects running time is O( N + M *[lg* N]) ~ O(M+N)
*/

class WQUPC{
	private int []parent;
	private int []rank;
	private int count;

	public WQUPC(int n){
		count = n;
		parent=new int[n];
		rank=new int[n];
		for(int i=0;i<parent.length;i++){ 
			parent[i]=i; 
			rank[i]=0; 
		}
	}
	
	public int count() {
        	return count;
	}
	
	//chase the parent pointer until you reach the root and perform path compression side by side
	private int find(int j){
		while(j!=parent[j]){
			parent[j]=parent[parent[j]];
			j=parent[j];
		}
		return j;
	}
	
	//check if p and q have same root
	public boolean isConnected(int p,int q) {return find(p)==find(q);}	
	
	public void union(int p,int q){
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP==rootQ) return;
		// make root of smaller rank point to root of larger rank
        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
	}
	
	void print(){
		for(int i =0;i<parent.length;i++) System.out.print(parent[i]+"\t");
	}
	
	public static void main(String[] args){
		 /*
		 WQUPC qu = new WQUPC(5);
		 qu.union(0,1);
		 System.out.println(qu.isConnected(1,0));
		 System.out.println(qu.isConnected(3,0));
		 qu.print();
		 */
		 
	}
}