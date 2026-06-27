/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null && curr.val != key){
            parent = curr;
            if(key < curr.val)
            curr = curr.left;
            else
            curr = curr.right;
        }

        if(curr == null)
        return root;

        if(curr.left != null && curr.right != null){

            TreeNode successorParent = curr;
            TreeNode successor = curr.right;

            while(successor.left != null){
                successorParent = successor;
                successor = successor.left;
            }

            curr.val = successor.val;

            curr = successor;
            parent = successorParent;
        }

        TreeNode child;

        if(curr.left != null)
        child = curr.left;
        else
        child = curr.right;

        if(parent == null)
        return child;

        if(parent.left == curr)
        parent.left = child;
        else
        parent.right = child;

        return root;
    }
}