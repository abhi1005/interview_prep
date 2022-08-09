package array;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> myList = new ArrayList<>();
        return permute(myList, nums, 0, nums.length - 1);

    }

    private List<List<Integer>> permute(List<List<Integer>> myList,int[] nums, int start, int end){
        if(start == end){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            myList.add(list);
            return myList;
        }
        for(int i=start; i<=end; i++){
            swap(nums, i, start);
            permute(myList, nums, start+1, end);
            swap(nums, start, i);
        }
        return myList;
    }

    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
