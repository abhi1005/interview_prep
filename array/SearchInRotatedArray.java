package array;

public class SearchInRotatedArray {

//    public int search(int[] nums, int target) {
//        int pivot = findPivot(nums, 0, nums.length);
//        int start = nums[0] > target ? pivot+1 : 0;
//        int end = start != 0 ? nums.length : pivot+1;
//        while(start <= end && start < nums.length){
//            int index = (start + end) / 2;
//            if(nums[index] == target)
//                return index;
//            else if(nums[index] < target)
//                start = index + 1;
//            else
//                end = index;
//        }
//        return -1;
//    }

    private int findPivot(int[] nums, int begin, int end){
        int index = (begin + end) / 2;
        if(index == nums.length - 1)
            return -1;
        if(index < end  && nums[index] > nums[index+1])
            return index;
        int left =  findPivot(nums, begin, index);
        int right = findPivot(nums, index+1, end);
        return left >= 0 ? left : right;
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target)
                return mid;
            else{
                if(nums[mid] < nums[start]){
                    if(target > nums[start] && target > nums[end]){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }else{
                    if(target > nums[start] && target > nums[end]){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {3,4,5,6,7,1,2};
        //int arr[] = {3};
        System.err.println(search(arr,3));
    }

}
