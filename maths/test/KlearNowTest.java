package maths.test;

import java.util.ArrayList;
import java.util.List;

public class KlearNowTest {

    static List<List<Integer>> mainList = new ArrayList<>();

    public static void main(String[] args) {
        //find pairs whose sum is equal to = 12
        //1,5,8,4,2,7,3
        int arr[] = {1,5,8,4,2,7,3};
        int sum = 12;
        getPairs(arr, sum, arr.length-1, new ArrayList<>());
        System.err.println(mainList);
    }

    public static void getPairs(int arr[], int sum, int index, List<Integer> list){

        if(sum == 0 && index == 0){
            mainList.add(list);
            return;
        }

        if(sum != 0 && index == 0 && sum-arr[0] == 0){
            list.add(arr[0]);
            mainList.add(list);
            return;
        }

        if(index == 0)
            return;

        //ignore here
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        getPairs(arr, sum, index - 1, newList);

        //select the current element
        list.add(arr[index]);
        getPairs(arr, sum - arr[index], index - 1, list);


    }
}
