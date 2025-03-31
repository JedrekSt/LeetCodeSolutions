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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List <List <Integer>> ans = new ArrayList<>();
        List <Integer> prefix = new ArrayList<>();
        recurse(ans,root,prefix,targetSum);
        return ans;
    }

    public void recurse(List<List<Integer>> ans, TreeNode node, List<Integer> prefix, int target){
        if(node != null && node.left == null && node.right == null && target == node.val){
            prefix.add(node.val);
            ans.add(prefix);
            return;
        }else if(node != null){
            List <Integer> right_prefix = new ArrayList<>(prefix);
            List <Integer> left_prefix = new ArrayList<>(prefix);
            int key = node.val;
            right_prefix.add(key);
            left_prefix.add(key);
            recurse(ans,node.left,left_prefix,target - key);
            recurse(ans,node.right,right_prefix,target - key);
        }else{
            return;
        }
    }
}