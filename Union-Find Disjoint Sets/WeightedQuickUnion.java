/*
Weighted Quick Union with Path Compression (Union by size)
Initialisation: O(N) for Weighted Quick Union
Find: O(lg N) 	     for Weighted Quick Union
Union: O(lg N)	     for Weighted Quick Union	
For M union-find operation on N objects running time is O( N + M *[lg N])
*/
class WeightedQuickUnion{
	private int []parent;
	private int []size;
	private int count;

	public WeightedQuickUnion(int n){
		count = n;
		parent=new int[n];
		size=new int[n];
		for(int i=0;i<parent.length;i++){ 
			parent[i]=i; 
			size[i]=1; 
		}
	}
	
	public int count(){
        return count;
    }
	
	//chase the parent pointer until you reach the root and perform path compression side by side
	private int find(int j){
		while(j!=parent[j])
			j=parent[j];
		return j;
	}
	
	//check if p and q have same root
	public boolean isConnected(int p,int q) {return find(p)==find(q);}	
	
	public void union(int p,int q){
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP==rootQ) return;
		// make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
	}
	
	void print(){
		for(int i =0;i<parent.length;i++) System.out.print(parent[i]+"\t");
	}
	
	public static void main(String[] args){
		 /*
		 WeightedQuickUnion qu = new WeightedQuickUnion(5);
		 qu.union(0,1);
		 System.out.println(qu.isConnected(1,0));
		 System.out.println(qu.isConnected(3,0));
		 qu.print();
		 */
		 
	}
}