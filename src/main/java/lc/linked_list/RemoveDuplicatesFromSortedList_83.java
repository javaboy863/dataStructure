//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表

package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * 因为是有序的
 * 在递推之后回归的过程中我们可以比较当前链表和子链的值是否相等，相等的话就直接返回子链，否则就返回当前链表。
 * 链表的递归，可以想象成不断的把问题交给子链去解决，最后返回的时候也是不断的返回子链的结果。
 */
public class RemoveDuplicatesFromSortedList_83 {
	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedList_83().new Solution();
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
		public ListNode deleteDuplicates(ListNode head) {
            if (head ==null || head.next == null){
                return head;
            }

            head.next = deleteDuplicates(head.next);
            return head.val == head.next.val?head.next:head;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}