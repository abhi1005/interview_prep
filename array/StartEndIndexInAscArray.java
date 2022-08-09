package array;

public class StartEndIndexInAscArray {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.err.println(searchRange(nums, 8));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int startIdx = 100001;
        int endIdx = -1;
        //first find start index
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                startIdx = Math.min(startIdx, mid);
                end = mid - 1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        start = 0; end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                endIdx = Math.max(endIdx, mid);
                start = mid + 1;

            }
            else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        int ret[]  = new int[2];
        ret[0] = startIdx != 100001 ? startIdx : -1;
        ret[1] = endIdx != -1 ? endIdx : -1;
        return ret;
    }
}
