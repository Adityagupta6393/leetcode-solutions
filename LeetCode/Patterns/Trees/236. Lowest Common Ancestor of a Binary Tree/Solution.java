/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean check(TreeNode root, TreeNode tar){
        if(root==null) return false;

        if(root.val==tar.val) return true;

        boolean left = check(root.left, tar);
        boolean right = check(root.right, tar);

        return left || right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr.val == p.val && (check(root.left, q) || check(root.right, q))) return p;

            if(curr.val == q.val && (check(root.left, p) || check(root.right, p))) return q;
            if((check(curr.left, p) && check(curr.right, q)) ||(check(curr.left, q) && check(curr.right, p)) ) return curr;


            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);

        }
        return null;
    }
}