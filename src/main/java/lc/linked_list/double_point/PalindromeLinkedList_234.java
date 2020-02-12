//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

package lc.linked_list.double_point;

import dataStructure.linked_list.ListNode;

public class PalindromeLinkedList_234 {
	public static void main(String[] args) {
		Solution solution = new PalindromeLinkedList_234().new Solution();
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
		public boolean isPalindrome(ListNode head) {
			ListNode fast = head;
			ListNode slow = head;
			if (fast == null || fast.next == null) return true;
			//找中点
			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			//中点后面的开始翻转
			ListNode newHead = reverseList(slow.next);
			while (newHead != null) {
			    //依次对比头和翻转后的头
				if (head.val != newHead.val) return false;
				head = head.next;
				newHead = newHead.next;
			}
			return true;
		}

		//反转链表函数--详情请看前文
		private ListNode reverseList(ListNode head) {
			if (head.next == null) return head;
			ListNode pre = null;
			ListNode tmp;
			while (head != null) {
				tmp = head.next;//tmp暂存当前节点的下一个节点
				head.next = pre;//当前节点下一个指向pre
				pre = head;//刷新pre
				head = tmp;//刷新当前节点为tmp
			}
			return pre;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}