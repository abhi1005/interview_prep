package stack;

import java.util.Stack;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class WaterTrapped {
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        int total = 0;
        int max = height[0];
        stack.push(height[0]);
        for(int i=1;i<height.length;i++){
            if(height[i] > max){
                while(!stack.isEmpty()){
                    total += (max-stack.peek());
                    stack.pop();
                }
                max = height[i];
            }
            stack.push(height[i]);
            //System.err.println(total);
        }
        int secondMax = -1;
        if(!stack.isEmpty())
            secondMax = stack.peek();
        while(!stack.isEmpty()){
            if(stack.peek() > secondMax){
                secondMax = stack.peek();
            }
            if(stack.peek() != max)
                total += secondMax - stack.peek();
            stack.pop();
        }
        return total;
    }



    public static void main(String[] args) {
        //int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int height[] =  {4,2,0,3,2,5};
        //int height[] = {1,2,3,4,5,6,7};
        //int height[] = {7,6,5,4,3,2,1};
        //int height[] = {7,6,5,4,3,2,1,9};
        //int height[] = {7};
        //int height[] = {6,6};
        //int height[] = {0,1,0,2,1,0,1,3,1,1,1,1};
        int height[] = { 0,1,0,2,1,0,1,6,3,1,3,1,5 };
        System.err.println(trap(height));
    }
}
