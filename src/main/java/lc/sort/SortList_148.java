//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表

package lc.sort;

import dataStructure.linked_list.ListNode;

/**
 * 由于是nlogn的时间复杂度，并且空间复杂度是 常数级的，进行链表排序。
 * 我们知道时间复杂度为nlogn的有三种排序：
 *   快速排序、堆排序、归并排序。
 * 但是由于快速排序是在数组里进行交换操作，所以不适用于链表。
 * 堆排序的话需要额外的空间堆来进行调整，空间复杂度不满足常数阶了。
 * 结论：只能用归并排序了
 */
public class SortList_148 {
	public static void main(String[] args) {
		Solution solution = new SortList_148().new Solution();
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
		public ListNode sortList(ListNode head) {
			//归并排序
			//1、先将链表递归分成两个链表，用的是快慢指针

			if (head == null || head.next == null) {   //递归终止条件，该链表为一个结点时，
				return head;
			}

			ListNode slow = head, fast = head, prev = null;  //开始时快慢指针都指向链表第一个节点
			while (fast != null && fast.next != null) {
				prev = slow;   //prev的作用是分割链表 如果链表节点个数为奇数个，
				// 前半部分比后半部分少一个，如果是偶数，则前和后半部分 平分
				slow = slow.next;
				fast = fast.next.next;
			}

			prev.next = null;
			ListNode l1 = sortList(head);
			ListNode l2 = sortList(slow);

			return merge(l1, l2);
		}

		//2、再将两链表进行合并
		public ListNode merge(ListNode l1, ListNode l2) {
			ListNode l = new ListNode(0);
			ListNode p = l;
			while (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					p.next = l1;
					l1 = l1.next;
					p = p.next;
				} else {
					p.next = l2;
					l2 = l2.next;
					p = p.next;
				}
			}

			if (l1 != null) {
				p.next = l1;
			}

			if (l2 != null) {
				p.next = l2;
			}
			return l.next;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}