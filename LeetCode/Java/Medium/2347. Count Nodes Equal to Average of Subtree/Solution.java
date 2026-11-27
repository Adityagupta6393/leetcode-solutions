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
        int count;
        int sum;

        Pair(int count, int sum){
            this.count = count;
            this.sum = sum;
        }
    }
    int count = 0;
    public Pair findCountAndSum(TreeNode node){
        if(node==null) return new Pair(0,0);

        Pair left = findCountAndSum(node.left);

        Pair right = findCountAndSum(node.right);

        int cnt = left.count + right.count + 1;
        int sum = left.sum + right.sum + node.val;

        if(Math.floor(sum/cnt)==node.val) count++;

        return new Pair(cnt , sum);
    }
    
    public int averageOfSubtree(TreeNode root) {
        Pair pair = findCountAndSum(root);

        return count;
    }
}