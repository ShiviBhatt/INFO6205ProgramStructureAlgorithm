package algorithm.Practice;

import java.util.Stack;

public class Q5InfixPostFixEvaluator {
	static int sym(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	static String infixToPostfix(String str) {
		String result = new String("");
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (Character.isLetterOrDigit(c))
				result += c;
			else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();
				if (!stack.isEmpty() && stack.peek() != '(')
					return "invalid expression";
				else
					stack.pop();
			} else {
				while (!stack.isEmpty() && sym(c) <= sym(stack.peek())) {
					if (stack.peek() == '(')
						return "invalid expression";
					result += stack.pop();
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "invalid expression";
			result += stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "(4+8)*(6-5)/((3-2)*(2+2))";
		System.out.println(infixToPostfix(str));
	}
}
