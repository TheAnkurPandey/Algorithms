public class FrequencyCounter{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int minLen = sc.nextInt();
		ST<String, Integer> st = new ST<String, Integer>;
		while(){
			String key = sc.next();
			if(key.length<minLen) continue;
			if(!st.contains(key)) st.put(key, 1);
			else st.put(key, st.get()+1);

		}
		String max = "";
		st.put(max,0);
		for(String x: st.keys())
			if(st.get(x)>st.get(max))
				max = x;
		System.out.println(max+ " " + st.get(max));
	}
}