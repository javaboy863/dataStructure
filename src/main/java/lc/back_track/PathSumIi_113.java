//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索

package lc.back_track;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi_113 {
	public static void main(String[] args) {
		Solution solution = new PathSumIi_113().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            helper(root, sum, res, new ArrayList<>());
            return res;

        }

        public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> current) {
            if (root == null) return;
            //先考察当前元素
            current.add(root.val);
            //如果是子节点并且值正好等于sum
            if (root.left == null && root.right == null && sum == root.val) {
                res.add(new ArrayList<>(current));
                //回溯
                current.remove(current.size() - 1);
                return;
            }
            //分别取左右子树递归找
            helper(root.left, sum - root.val, res, current);
            helper(root.right, sum - root.val, res, current);
            //回溯
            current.remove(current.size() - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}