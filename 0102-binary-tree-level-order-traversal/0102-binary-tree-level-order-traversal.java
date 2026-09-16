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
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> lvl = new ArrayList<>();
            
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                lvl.add(n.val);
                
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            
            res.add(lvl);
        }
        
        return res;
    }
}