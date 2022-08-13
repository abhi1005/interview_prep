package binaryTree;


import binaryTree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        List<List<Integer>> ret = new ArrayList<>();
        bfs(root, map, 0);
        for(Map.Entry<Integer, List<Integer>> mapEntry : map.entrySet()){
            ret.add(new ArrayList<>(mapEntry.getValue()));
        }
        return ret;
    }
    private void bfs(TreeNode root, Map<Integer,List<Integer>> map, int index){
        if(root == null)return;
        if(!map.containsKey(index)){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(root.val);
            map.put(index, tempList);
        }else{
            List<Integer> tempList = map.get(index);
            tempList.add(root.val);
        }
        bfs(root.left, map, index+1);
        bfs(root.right, map, index+1);
    }
}
