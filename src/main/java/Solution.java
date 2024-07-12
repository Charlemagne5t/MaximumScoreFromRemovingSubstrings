import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int res = 0;
        Deque<Character> stack = new ArrayDeque<>();
        if(y > x) {
            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    if (ch == 'a' && stack.peek() == 'b') {
                        stack.pop();
                        res += y;
                    } else {
                        stack.push(ch);
                    }
                }
            }
            Deque<Character> stack2 = new ArrayDeque<>();
            if (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            while (!stack.isEmpty()) {
                if(!stack2.isEmpty()) {
                    if (stack2.peek() == 'b' && stack.peek() == 'a') {
                        res+= x;
                        stack.pop();
                        stack2.pop();
                    }else stack2.push(stack.pop());
                }else stack2.push(stack.pop());
            }
        }else {
            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    if (ch == 'b' && stack.peek() == 'a') {
                        stack.pop();
                        res += x;
                    } else {
                        stack.push(ch);
                    }
                }
            }
            Deque<Character> stack2 = new ArrayDeque<>();
            if (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            while (!stack.isEmpty()) {
                if(!stack2.isEmpty()) {
                    if (stack2.peek() == 'a' && stack.peek() == 'b') {
                        res+= y;
                        stack.pop();
                        stack2.pop();
                    }else stack2.push(stack.pop());
                }else stack2.push(stack.pop());
            }
        }
        return res;
    }
}
