//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索

  package lc.tree;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 采用前序遍历。采用 根->右->左 顺序进行遍历，并将每一层的第一个节点添加到结果集中：
 */
public class BinaryTreeRightSideView_199 {
      public static void main(String[] args) {
           Solution solution = new BinaryTreeRightSideView_199().new Solution();
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        rightSideView(root, 0, ret);

        return ret;
    }

    public void rightSideView(TreeNode root,
                              int level, List<Integer> ret) {
        if (root == null)
            return;
        // 当等于size的时候说明是最右侧结点，因为第一次是跟，第二次是右节点。
        if (ret.size() == level)
            ret.add(root.val);

        rightSideView(root.right, level + 1, ret);
        rightSideView(root.left, level + 1, ret);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }