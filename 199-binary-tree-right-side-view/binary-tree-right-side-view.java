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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode node, int level, List<Integer> result){

        if(node == null)
        return;

        if(level == result.size()){
            result.add(node.val);
        }

        traverse(node.right, level + 1, result);
        traverse(node.left, level + 1, result);
    }
}