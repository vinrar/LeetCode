package contest154;

import java.util.Stack;

public class Q2 {

    static char left = '(';
    static char right = ')';

    public static void main(String[] args) {
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if(currentChar == left) {
                i = pushToStack(s, i + 1, stack);
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            } else {
                sb.append(currentChar);
            }
        }



        return sb.toString();
    }

    private static int pushToStack(String string, int i, Stack<Character> stack) {
        for(; i < string.length(); i++) {
            char currentchar = string.charAt(i);
            if(currentchar == left) {
                Stack<Character> s = new Stack();
                i = pushToStack(string, i + 1, s);
                while(!s.isEmpty()) {
                    stack.add(s.pop());
                }
            } else if(currentchar == right) {
                return i;
            } else {
                stack.push(currentchar);
            }
        }

        return i + 1;
    }
}
