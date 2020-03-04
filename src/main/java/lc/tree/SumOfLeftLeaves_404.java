//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树

  package lc.tree;

import dataStructure.tree.TreeNode;

public class SumOfLeftLeaves_404 {
      public static void main(String[] args) {
           Solution solution = new SumOfLeftLeaves_404().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
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
    public int sumOfLeftLeaves(TreeNode root) {
        //递归终止条件
        if (root ==null ) return 0;
        int sum = 0;
        //取每个节点的左子节点（这个节点不能有孩子节点，否则就递归找到符合条件的）
        if (root.left != null && root.left.left == null&& root.left.right == null){
            sum+=root.left.val;
        }
        //分别递归去孩子节点里找
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }