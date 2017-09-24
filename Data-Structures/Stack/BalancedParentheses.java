import java.io.*;
import java.util.Stack;

public class BalancedParentheses{
	public static boolean isBalanced(String str) {
		Stack<Character> stack  = new Stack<Character>();
        	if (str == null || str.length() == 0) {
	            return true;
	        }
	        int i = 0;
	        while (i < str.length()) {
	            char ch = str.charAt(i);
	            if (ch == '(' || ch == '[' || ch == '{') {
	            	stack.push(ch);
	            } else if(ch == ']') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '[') return false;
	
        	    }else if(ch == ')') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '(') return false;
	
	            }else if(ch == '}') {
	                if(stack.isEmpty()) return false;
	                if(stack.pop() != '{') return false;
	            }
	            i++;
        	}
	        return stack.isEmpty();
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string");
		String in = br.readLine();
		System.out.println(isBalanced(in));
	}
}