//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
// Related Topics 链表

package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * 题目：反转数组，保持链表值不变，只是next反转
 * 思路：定义pre，cur，next三个指针。pre一开始是null。cur=当前的head，next等于head.next。初始化完毕。
 * 然后cur.next指向pre，完成当前节点的指针变动。然后移动定义的三个指针：pre后移指向cur，cur指向next，next指向cur.next
 *
 */
public class ReverseLinkedList_206 {

	public static void main(String[] args) {
		Solution solution = new ReverseLinkedList_206().new Solution();
		int[] nums = {0, 1, 2, 3, 4};
        System.out.println(nums);
        ListNode listNode = new ListNode(nums);
		ListNode listNode1 = solution.reverseList(listNode);
		System.out.println(listNode1);
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

		public ListNode reverseList(ListNode head) {
			ListNode pre = null;
			ListNode cur = head;
			while (cur != null) {
				ListNode next = cur.next;
                //先反转指针
				cur.next = pre;
                //pre 指向 cur指针
                pre = cur;
                //cur指向next指针
                cur = next;
				//完毕
			}
			return pre;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}