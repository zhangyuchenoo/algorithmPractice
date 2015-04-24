package cn.johnson.algorithm.applications;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReversePoland {

	public static void main(String[] args) throws IOException {

		InputStreamReader reader = new InputStreamReader(System.in);

		Stack<Character> operatorStack = new Stack<Character>();

		char c = 0;
		while ((c = (char) reader.read()) != -1) {

			if (Character.isDigit(c)) {

				System.out.print(c + " ");

			} else if (isOperator(c)) {

				// 如果是左括号
				if ('(' == c) {
					operatorStack.push(c);
				} else if (')' == c) {
					char d = 0;
					while ('(' != (d = operatorStack.pop())) {
						System.out.print(d);
					}
				} else {

					if (operatorStack.isEmpty()) {
						operatorStack.push(c);
					} else {

						Character top = operatorStack.peek();
						// 如果当前操作符的优先级小于栈顶的操作符 则将栈顶操作符出栈 继续比较直到栈顶操作符优先级大于当前操作符
						if (comparePriority(c, top) <= 0) {
							while (comparePriority(c, top) <= 0) {
								System.out.print(operatorStack.pop());
								if (operatorStack.isEmpty())
									break;
								top = operatorStack.peek();
							}
							operatorStack.push(c);
						} else {
							operatorStack.push(c);
						}
						// 如果栈顶操作符优先级等于当前操作符 则将栈顶操作符先出栈 并将当前操作符入栈
					}
				}

			} else if (c == '\r') {
				break;
			}
		}

		/* 将栈里剩余操作数全部弹出 */
		while (!operatorStack.isEmpty()) {
			System.out.print(operatorStack.pop());
		}

	}

	private static int comparePriority(char c, char top) {

		if (getPriority(c) < getPriority(top))
			return -1;
		else if (getPriority(c) == getPriority(top))
			return 0;
		else
			return 1;

	}

	private static int getPriority(char c) {

		if ('+' == c || '-' == c) {
			return 1;
		} else if ('*' == c || '/' == c) {
			return 2;
		}

		return 0;
	}

	private static boolean isOperator(char c) {

		return String.valueOf(c).matches("[\\+\\-\\*\\/\\(\\)]");

	}
}
