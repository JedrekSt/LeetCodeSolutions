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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode iter = root;
        Wrapper wrap = new Wrapper(iter);
        add_rec(wrap,val);
        return wrap.root;
    }

    public void add_rec(Wrapper node,int val){
        TreeNode root = node.root;
        if(root == null){
            node.root = new TreeNode(val);
        }
        else{
            int actual_val = root.val;
            if(val < actual_val){
                if(root.left != null){
                    insertIntoBST(root.left,val);
                }
                else{
                    root.left = new TreeNode(val);
                }
            }else{
                if(root.right != null){
                    insertIntoBST(root.right,val);
                }
                else{
                    root.right = new TreeNode(val);
                }
            }
        }
    }
}

class Wrapper{
    TreeNode root;

    Wrapper(TreeNode root_val){
        root = root_val;
    };
}
