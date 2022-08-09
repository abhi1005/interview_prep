package stack;

import java.util.Stack;

public class ReverseInteger {
    public static int reverse(int x) {
        Stack<Integer> q = new Stack<>();
        while(x != 0){
            q.push(x%10);
            x /= 10;
        }
        long result = 0;
        long mul = 1;
        while(!q.isEmpty()){
            result = result + q.peek() * mul;
            System.err.println(result);
            q.pop();
            mul *= 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }

    public static void main(String[] args) {
        System.err.println(reverse(1534236469));
    }
}
