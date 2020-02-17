//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索

package lc.tree;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
	public static void main(String[] args) {
		Solution solution = new BinaryTreePaths_257().new Solution();
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
		public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            dfs(root, res, "");
            return res;

		}

        public void dfs(TreeNode root,List<String> res,String str) {
		    //递归终止条件
		    if (root == null)return;
            //没有左右孩子,当前节点是叶子节点,所以形成一条路径=str(根节点到父节点路径)+当前节点
		    if (root.left ==null && root.right==null){
		        res.add(str+root.val);
		        return;
            }
            //存在左孩子,所以到当前节点路径=str(根节点到父节点路径)+当前节点值+"->"
            if (root.left != null){
                dfs(root.left, res, str+root.val+"->");
            }
            if (root.right != null){
                dfs(root.right, res, str+root.val+"->");
            }



        }





	}
//leetcode submit region end(Prohibit modification and deletion)

}