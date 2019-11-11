import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String args[]) {
        String input = "()(()()))(())(()())";
        int startIndex = -1;
        int endIndex = -1;
        int[] output = getLongestLengthValidParanthesis(input, startIndex, endIndex);
        System.out.println(output[0]);
        System.out.println("The longest valid parenthesis string is: ");
        startIndex = output[1];
        endIndex = output[2];
//        System.out.println(startIndex + " " + endIndex);
        System.out.print(input.substring(startIndex,endIndex+1));
    }

    static int[] getLongestLengthValidParanthesis(String input, int startIndex, int endIndex) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.empty()) {
                    int tempRes = i - stack.peek();
                    if (tempRes > res) {
                        res = tempRes;
                        startIndex = stack.peek() + 1;
                        endIndex = i;
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        return new int[]{res, startIndex, endIndex};
    }
}
