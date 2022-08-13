package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int nums[] = {-5,-3,-9,-2,-1,0,4,2,1};
        System.err.println(l.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int maxSeq = 1;
        Map<Integer, Node> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], new Node(i, -1, false));
        }
        for(Map.Entry<Integer, Node> mapEntry : map.entrySet()){
            int val = mapEntry.getKey();
            Node parentNode = mapEntry.getValue();
            int currentSeq = 1;
            boolean subsetBreakCond = false;
            while(!subsetBreakCond){
                if(map.containsKey(val+1)){
                    Node node = map.get(val+1);
                    if(!node.isProcessed){
                        node.parentIndex = parentNode.selfIndex;
                        node.isProcessed = true;
                        val++;
                        currentSeq++;
                    }else{
                        subsetBreakCond = true;
                    }
                }else{
                    subsetBreakCond = true;
                }
            }
            maxSeq = Math.max(maxSeq, currentSeq);
        }
        return maxSeq;
    }
}

class Node{
    int selfIndex;
    int parentIndex;
    boolean isProcessed;
    public Node(int selfIndex, int parentIndex, boolean isProcessed){
        this.selfIndex = selfIndex;
        this.parentIndex = parentIndex;
        this.isProcessed = isProcessed;
    }
}
