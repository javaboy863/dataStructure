//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索

package lc.tree;

import dataStructure.tree.TreeNode;

/**
 * 一棵高度平衡的二叉树是左右子树的高度相差不超过1，对其左右子树也是如此。
 */
public class BalancedBinaryTree_110 {
	public static void main(String[] args) {
		Solution solution = new BalancedBinaryTree_110().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public boolean isBalanced(TreeNode root) {
			if(root==null) return true;
			//左右子树高差相差>1直接返回false
			if(Math.abs(Depth(root.left)-Depth(root.right))>1)
				return false;
			//否则对比左子树右子树,因为其左右子树也要相差不大于1
			return isBalanced(root.left)&&isBalanced(root.right);
		}

		private int Depth(TreeNode root){//求深度
			if(root==null) return 0;
			return Math.max(Depth(root.left),Depth(root.right))+1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}