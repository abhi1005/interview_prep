package array;

import java.util.ArrayList;
import java.util.List;

public class IngredientsProblem {

    static List<List<Integer>> subsets = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> ingredients = new ArrayList<>();
        List<Integer> ing1 = new ArrayList<>();ing1.add(1);ing1.add(2);ing1.add(3);
        List<Integer> ing2 = new ArrayList<>();ing2.add(4);ing2.add(5);ing2.add(6);
        List<Integer> ing3 = new ArrayList<>();ing3.add(7);ing3.add(8);ing3.add(9);
        List<Integer> ing4 = new ArrayList<>();ing4.add(9);ing4.add(8);ing4.add(12);
        List<Integer> ing5 = new ArrayList<>();ing5.add(5);ing5.add(7);ing5.add(9);
        ingredients.add(ing1);
        ingredients.add(ing2);
        ingredients.add(ing3);
        ingredients.add(ing4);
        ingredients.add(ing5);

        List<Integer> targets1 = new ArrayList<>();
        targets1.add(5);targets1.add(7);targets1.add(9);

        List<Integer> targets2 = new ArrayList<>();
        targets2.add(11);targets2.add(13);targets2.add(15);

        List<Integer> targets3 = new ArrayList<>();
        targets3.add(52);targets3.add(14);targets3.add(3);

        List<List<Integer>> targets = new ArrayList<>();
        targets.add(targets1);
        targets.add(targets2);
        targets.add(targets3);

        List<Integer> tempList = new ArrayList<>();
        tempList.add(1);
        tempList.add(4);
        tempList.add(7);
        tempList.add(9);
        tempList.add(5);

        boolean dp[][] = getIngredientsWithSumEqualToTarget(ingredients, targets1);
        getAllSubsetsWithSum(tempList, 4, 5,dp,new ArrayList<>());
        //1 4 7 9 5
        //5
        //System.err.println(subsets.size());
        System.err.println(subsets);
        //System.err.println(getIngredientsWithSumEqualToTarget(ingredients, targets1));
        //System.err.println(getIngredientsWithSumEqualToTarget(ingredients, targets2));
        //System.err.println(getIngredientsWithSumEqualToTarget(ingredients, targets3));

    }

    public static boolean[][] getIngredientsWithSumEqualToTarget(List<List<Integer>> ingredients, List<Integer> targets){
        int target = targets.get(0);
        int index = 0;

        boolean dp[][] = new boolean[ingredients.size()+1][target+1];

        for(int i=0;i<ingredients.size()+1;i++)
            dp[i][0] = true;

        for(int i=1;i<ingredients.size()+1;i++){
            for(int j=1;j<target+1;j++){
                if(ingredients.get(i-1).get(index) > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - ingredients.get(i-1).get(index)];
                }
            }
        }

        return dp;
    }

    static void getAllSubsetsWithSum(List<Integer> nums, int index, int sum, boolean dp[][], List<Integer> subset){

        //if reached at the end and sum becomes zero
        if(index == 0 && sum == 0){
            subsets.add(subset);
            return;
        }

        //if reached at the end and include the 0th index into solution set which makes sum 0
        if(index == 0 && sum != 0 && dp[0][sum]){
            subsets.add(subset);
            return;
        }

        //ignoring the current element
        if(dp[index-1][sum]){
            List<Integer> newSet = new ArrayList<>();
            newSet.addAll(subset);
            getAllSubsetsWithSum(nums, index - 1, sum, dp, newSet);
        }

        //including the current element
        if(sum >= nums.get(index) && dp[index-1][sum-nums.get(index)]){
            subset.add(nums.get(index));
            getAllSubsetsWithSum(nums, index - 1, sum-nums.get(index), dp, subset);
        }

    }
}
