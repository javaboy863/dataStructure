//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

package lc.linked_list.double_point;

import dataStructure.linked_list.ListNode;

public class RemoveNthNodeFromEndOfList_19 {
	public static void main(String[] args) {
		Solution solution = new RemoveNthNodeFromEndOfList_19().new Solution();
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
		public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode dummyHead = new ListNode(-1);
			dummyHead.next = head;
			ListNode p = dummyHead;
			ListNode q = dummyHead;
			//p 和q 之间距离固定n
			//q移动n+1
			for (int i = 0; i < n+1; i++) {
				q = q.next;
			}
			//q直到指向null，p也就到了指定位置了。因为p和q之间距离是固定的
			while (q != null){
				p = p.next;
				q =q.next;
			}
			ListNode delNode  = p.next;
			p.next = delNode.next;
			return dummyHead.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}