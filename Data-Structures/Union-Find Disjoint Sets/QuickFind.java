/*
quick find algoritm
Initialisation: O(N)
find: O(1)
Union: O(N)
Cost of union is more to flatten the tree
*/ 
class QuickFind{
	private int []id;
	
	public QuickFind(int N){
		id=new int[N];
		for(int i=0;i<id.length;i++) id[i]=i;
	}
	
	public boolean isConnected(int p,int q) {return id[p]==id[q];}	
	
	public void union(int p,int q){
		int pid = id[p];
		int qid = id[q];
		//Change all the entries with id[p] to id[q]
		for(int i=0;i<id.length;i++)
			if(id[i]==pid) id[i]=qid;
	}
	
	void print(){
		for(int i =0;i<id.length;i++) System.out.print(id[i]+"\t");
	}
	public static void main(String[] args){
		 /*
		 QuickFind qf = new QuickFind(5);
		 qf.union(0,1);
		 System.out.println(qf.isConnected(1,0));
		 System.out.println(qf.isConnected(3,0));
		 qf.print();
		 */
		 
	}
}