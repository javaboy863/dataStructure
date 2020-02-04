//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * ①1 ≤ m ≤ n ≤ 链表长度，由于m是最小的，所以当遍历到m的位置时就进行反转
 * ②一直反转到n的位置 首先定义一些指针，用于记录找到m位置的节点
 * 定义m前一个pre ，m位置pcur 两个指针
 */
public class ReverseLinkedListIi_92 {
	public static void main(String[] args) {
		Solution solution = new ReverseLinkedListIi_92().new Solution();
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
		public ListNode reverseBetween(ListNode head, int m, int n) {
			if (head == null|| head.next == null || m==n){
				return head;
			}
			ListNode dummyHead = new ListNode(-1);
			dummyHead.next = head;
			ListNode pre = dummyHead;
			for (int i = 1; i <m ; i++) {
				pre = pre.next;
			}
			//pre为m的前一个node。
			//pcur 为m 位置
			ListNode pcur = pre.next;
			//从m到n开始反转
			//输入: 1->2->3->4->5->NULL, m = 2, n = 4 输出: 1->4->3->2->5->NULL
			//TODO 此处这个交换不熟悉，应该多记下
			for (int i = m; i < n; i++) {
				//tmp = 3
				ListNode tmp = pcur.next;
				//m.next(2) = 3.next(4) ,2->4
				pcur.next = tmp.next;
				//3.next = 1.next(2) ,3->2
				tmp.next = pre.next;
				//1.next = 3 ,1->3
				pre.next = tmp;
				//之前是：1->2->3->4
				//一次循环后是：1->3->2->4
			}
			return dummyHead.next;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}