package binaryTree;

import binaryTree.node.TreeNode;

public class ValidBST {
    private boolean isValidBST(TreeNode root, int min, int max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    private boolean isValidBST(TreeNode root, TreeNode l, TreeNode r){
        if(root == null)
            return true;
        if(l != null && l.val <= root.val)
            return false;
        if(r != null && r.val >= root.val)
            return false;
        return isValidBST(root.left, root, r) && isValidBST(root.right, l , root);
    }
}
