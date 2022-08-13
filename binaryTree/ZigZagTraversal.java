package binaryTree;

import binaryTree.node.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {

    }
    static void zigzagLevelOrder(TreeNode root, List<List<Integer>> ret){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        int level = 0;
        while (!s1.isEmpty() || !s2.isEmpty()){
            if(level % 2 == 0){
                if(!s1.isEmpty()){
                    TreeNode node = s1.peek();
                    s1.pop();
                    addDataToLevel(node, ret, level);
                    if(node.left != null)
                        s2.push(node.left);
                    if(node.right != null)
                        s2.push(node.right);
                }else{
                    level++;
                }
            }else{
                if(!s2.isEmpty()){
                    TreeNode node = s1.peek();
                    s2.pop();
                    addDataToLevel(node, ret, level);
                    if(node.right != null)
                        s1.push(node.right);
                    if(node.left != null)
                        s1.push(node.left);
                }else{
                    level++;
                }
            }
        }
    }

    static private void addDataToLevel(TreeNode node, List<List<Integer>> ret, int level){
        List<Integer> list = ret.get(level);
        if(list == null){
            list = new ArrayList<>();
            ret.add(level, list);
        }
        list.add(node.val);
    }
}
