import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        if(x > y){
            Deque<Character> stack = new ArrayDeque<>();
            for(char ch : s.toCharArray()){
                if(!stack.isEmpty() && ch == 'b' && stack.peekLast() == 'a' ){
                    res += x;
                    stack.removeLast();
                }else {
                    stack.addLast(ch);
                }
            }
            Deque<Character> leftovers = new ArrayDeque<>();
            while(!stack.isEmpty()){
                char cur = stack.removeLast();
                if(!leftovers.isEmpty() && cur == 'b' && leftovers.peekLast() == 'a'){
                    res += y;
                    leftovers.removeLast();
                }else leftovers.addLast(cur);
            }
        }else {
            Deque<Character> stack = new ArrayDeque<>();
            for(char ch : s.toCharArray()){
                if(!stack.isEmpty() && ch == 'a' && stack.peekLast() == 'b' ){
                    res += y;
                    stack.removeLast();
                }else {
                    stack.addLast(ch);
                }
            }
            Deque<Character> leftovers = new ArrayDeque<>();
            while(!stack.isEmpty()){
                char cur = stack.removeLast();
                if(!leftovers.isEmpty() && cur == 'a' && leftovers.peekLast() == 'b'){
                    res += x;
                    leftovers.removeLast();
                }else leftovers.addLast(cur);
            }
        }

        return res;
    }
}
