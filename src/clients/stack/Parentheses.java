package clients.stack;

import java.util.Scanner;

import BagsStacksQs.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
	
	private static final char LEFT_PAREN     = '(';
	private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static boolean isBalanced(String item) {
    	Stack<Character> s = new Stack<Character>();
    	char[] p = item.toCharArray();
    	
    	for (char c : p) {
    		if (c == LEFT_PAREN || c == LEFT_BRACE || c == LEFT_BRACKET)
    			s.push(c);
    		
    		if (c == RIGHT_PAREN) {
    			if (s.isEmpty()) 			return false;
    			if (s.pop() != LEFT_PAREN) 	return false;
    		}
    		
    		if (c == RIGHT_BRACE) {
    			if (s.isEmpty()) 			return false;
    			if (s.pop() != LEFT_BRACE) 	return false;
    		}
    		
    		if (c == RIGHT_BRACKET) {
    			if (s.isEmpty()) 				return false;
    			if (s.pop() != LEFT_BRACKET) 	return false;
    		}
    	}
    	
    	return s.isEmpty();
    }

	public static void main(String args[]) { 
        try(Scanner scanner = new Scanner(System.in)) {
        	 String s = scanner.nextLine().trim();
        	 StdOut.println(isBalanced(s));
        }
	}
}
