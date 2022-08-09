package array;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ret = 0;
        while (left < right) {
            ret = max(ret, min(height[left], height[right]) * (right - left));
            int leftPrev = left, rightPrev = right;
            left = height[leftPrev] <= height[rightPrev] ? leftPrev + 1 : leftPrev;
            right = height[leftPrev] > height[rightPrev] ? rightPrev - 1 : rightPrev;
        }
        return ret;
    }

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.err.println(maxArea(height));
    }
}
