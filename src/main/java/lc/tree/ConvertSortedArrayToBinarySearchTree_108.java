//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

package lc.tree;


import dataStructure.tree.TreeNode;

/**
 * 首先要搞清楚一个问题：有序数组和二叉搜索树有什么关系呢？答案是二叉搜索树的中序遍历结果是有序数组。
 * 那么这个关系有什么用呢？注意题目要求转换得到的二叉搜索树是“高度平衡”的，那么试想，在一个平衡的二叉搜索树中，
 * 根节点的值在有序数组中的什么位置呢？答案是在有序数组的中间。我们再反过来看这个关系，当我们拿到一个有序数组的时候，
 * 我们就能知道，这个数组中间的元素就是对应二叉搜索树的根结点的值。我们再深入想想，根节点的左子结点是什么呢？
 * 有没有发现这像是一个重叠子问题：根节点的左子节点的值是原数组的左半数组的中间元素的值。
 * 例如，对于[1, 2, 3, 4, 5, 6, 7]，根节点的值就是4，此时左半数组是[1, 2, 3]，
 * 那么根结点的左子节点的值就是2，依此类推，我们就能建立如下的二叉搜索树：
 *
 * 注意刚才说“重叠子问题”，那么我们就可以用递归来解决，即，对于一个数组，取出中间元素值作为当前根结点，
 * 而根结点的左子树就是“以左半数组为输入的递归”，根节点的右子树就是“以右半数组为输入的递归”，对于当前递归返回当前根结点。
 */
public class ConvertSortedArrayToBinarySearchTree_108 {
	public static void main(String[] args) {
		Solution solution = new ConvertSortedArrayToBinarySearchTree_108().new Solution();
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
		public TreeNode sortedArrayToBST(int[] nums) {
			if (nums == null) {
				return null;
			}
			return convertTree(nums, 0, nums.length - 1);

		}

		private TreeNode convertTree(int[] nums, int l, int r) {//l：数组左边；r：数组右边，包括l和r
			if (l <= r) {
				int mid = (l + r) / 2;
				TreeNode newNode = new TreeNode(nums[mid]);
				newNode.left = convertTree(nums, l, mid - 1);
				newNode.right = convertTree(nums, mid + 1, r);
				return newNode;
			}
			else {
				return null;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}