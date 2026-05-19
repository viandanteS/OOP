package poo.string;

import java.util.Scanner;
import java.util.Stack;

public class ParentesiBilanciate {
	
	
	public static boolean parentesiBilanciate(String input) {
		Stack<Character> stack=new Stack<>();
		String regex="^[(){}\\[\\]<>]+$";
		
		if(!input.matches(regex)) throw new IllegalArgumentException("Input non valido!");
		
		for(char c:input.toCharArray()) {
			if(c=='(' || c=='[' || c=='{' || c=='<') {
				stack.push(c);				
			}
			else if(c==')' || c=='}' || c==']' || c=='>') {
				if(stack.empty()) return false; //chiusura senza apertura
				
				char top=stack.pop();
				if(!isMatchingPair(top,c)) return false;
			}
		}
		return stack.empty();
	}

	private static boolean isMatchingPair(char open, char close) {
		return	(open == '(' && close == ')') ||
				(open == '{' && close == '}') ||
				(open == '[' && close == ']') ||
				(open == '<' && close == '>');
    }

	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		for(;;) {
			System.out.print("Q to exit >> ");
			String parentesi=sc.nextLine();
			if(parentesi.toUpperCase().equals("Q")) {System.out.print("Bye..!"); break;}
			else System.out.println(parentesiBilanciate(parentesi));
		}
		
	}

}
