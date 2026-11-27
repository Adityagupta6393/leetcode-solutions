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
    class Pair{
        TreeNode node;
        int pos;

        Pair(TreeNode node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int firstPos = 0;
            int lastPos = 0;
            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int pos = curr.pos;
                if(node.left != null) q.offer(new Pair(node.left, pos * 2));
                if(node.right != null) q.offer(new Pair(node.right, pos * 2 + 1));

                if(i==0) firstPos = pos;
                if(i==size-1) lastPos = pos;
            }
            maxWidth = Math.max(maxWidth, lastPos - firstPos + 1);
        }
        return maxWidth;
    }
}