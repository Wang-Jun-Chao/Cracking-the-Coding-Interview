import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2016-01-07 15:11
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        List<Character> stack = new LinkedList<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if (!stack.isEmpty() && stack.get(stack.size() - 1) == '(' && c == ')') {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(c);
            }

        }


        return stack.isEmpty();
    }
}
