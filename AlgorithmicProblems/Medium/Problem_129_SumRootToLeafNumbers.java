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
    public int sumNumbers(TreeNode root) {
        List <Integer> arr = new ArrayList<>();
        recurse(arr,root,0);
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        return sum;
    }

    public void recurse(List<Integer> arr,TreeNode node, int num){
        if(node.left == null && node.right == null){
            arr.add(10 * num + node.val);
        }else{
            if(node.left != null){
                recurse(arr,node.left,10 * num + node.val);
            }
            if(node.right != null){
                recurse(arr,node.right,10*num + node.val);
            }
        }
    }
}