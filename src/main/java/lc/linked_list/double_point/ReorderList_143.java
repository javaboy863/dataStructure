//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表

package lc.linked_list.double_point;

import dataStructure.linked_list.ListNode;

/**
 * 1\找中点
 * 2\翻转中点之后的链表
 * 3\依次拼接
 */
public class ReorderList_143 {
	public static void main(String[] args) {
		Solution solution = new ReorderList_143().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public void reorderList(ListNode head) {
			if (head == null || head.next == null) return;
			ListNode slow = head;
			ListNode fast = head;
			// 找中点 1 2 3 4 5 6
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			// 翻转中点, 用插入法 1 2 3 6 5 4
			ListNode pre = slow;
			ListNode cur = slow.next;
			while (cur.next != null) {
				ListNode tmp = cur.next;
				cur.next = tmp.next;
				tmp.next = pre.next;
				pre.next = tmp;
			}

			// 拼接 1 6 2 5 3 4
			ListNode p1 = head;
			ListNode p2 = slow.next;
			while (p1 != slow) {
				// 建议大家这部分画图, 很容易理解的
				slow.next = p2.next;
				p2.next = p1.next;
				p1.next = p2;
				p1 = p2.next;
				p2 = slow.next;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}