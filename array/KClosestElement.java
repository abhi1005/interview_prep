package array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KClosestElement {

    public static void main(String[] args) {
        int arr[] = {-7,-5,-2,-1,0,1,2,3,4,5};
        int k = 4, x = 0;
        //int arr[] = {1,3};
        //int k = 1, x = 2;
        //int arr[] = {1,10,15,25,35,45,50,59};
        //int k = 1, x = 30;

        System.err.println(findClosestElements(arr, k , x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int index = binarySearchIndex(arr, 0 , arr.length - 1, x);
        System.err.println(index);
        Deque<Integer> res = new LinkedList<>();
        int i=index,j = index+1;
        int count = 0;
        while(count < k){
            if(i <= -1 && j < arr.length){
                res.addLast(arr[j++]);
            }else if(i > -1 && j == arr.length){
                res.addFirst(arr[i--]);
            }else{
                if(Math.abs(arr[i]-x) <= Math.abs(arr[j]-x)){
                    res.addFirst(arr[i--]);
                }else{
                    res.addLast(arr[j++]);
                }
            }
            count++;
        }
        return new ArrayList<>(res);
    }

    private static int binarySearchIndex(int[] arr, int start, int end, int x){
        int mid = -1;
        while(start < end){
            mid = start + (end - start)/2;
            if(arr[mid] > x && mid-1 > -1 && arr[mid - 1] < x){
                mid = mid -1;
                break;
            }else if(arr[mid] < x && mid+1 < arr.length && arr[mid + 1] > x){
                break;
            }
            else if(arr[mid] > x){
                end = mid - 1;
            }else if(arr[mid] < x){
                start = mid + 1;
            }else{
                break;
            }
        }
        return mid;
    }
}
