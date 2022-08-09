package array;

public class SortedArraySearch {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ret = searchRange(nums, 8);
        System.err.println(ret[0]+","+ret[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int startIdx = 100001;
        int endIdx = -1;
        while(start <= end){
            System.err.println(start+","+end);
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                //startIdx = Math.min(startIdx, modifiedBinarySearch(nums, start, mid, target));
                //endIdx = Math.max(endIdx, modifiedBinarySearch(nums, mid + 1, end, target));
                //start = end + 1;
//                startIdx = Math.min(startIdx, mid);
//                endIdx = Math.max(endIdx, mid);
//                start = start - 1;end = end + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        int ret[]  = new int[2];
        ret[0] = startIdx;
        ret[1] = endIdx;
        return ret;
    }

    private static int modifiedBinarySearch(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(nums[mid] == target && mid - 1 >= start && nums[mid - 1] != target ){
            return mid;
        }else if(nums[mid] == target && mid + 1 <= end && nums[mid + 1] != target ){
            return mid;
        }else if(nums[mid] < target){
            return modifiedBinarySearch(nums, mid + 1, end, target);
        }else{
            return modifiedBinarySearch(nums, start, mid - 1, target);
        }
    }
}
