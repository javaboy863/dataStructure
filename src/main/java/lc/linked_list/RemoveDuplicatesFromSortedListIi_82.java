//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表

package lc.linked_list;

import dataStructure.linked_list.ListNode;

public class RemoveDuplicatesFromSortedListIi_82 {
	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedListIi_82().new Solution();
		solution.deleteDuplicates(new ListNode(new int[]{1,2,3,3,4,4,5}));


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
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            head = dummy;
            ListNode p = head;
            while(p.next != null){
                //判断条件为p.next.next != null && p.next.val == p.next.next.val，就是判断两个相邻节点是否相等
                // ；如果不相等，也就是不需要删除，p前进一位。
                if(p.next.next != null && p.next.val == p.next.next.val){
                    //如果相等，则先记录下节点的值val，然后继续遍历下去，若节点的值为val，则指向下下个元素，
                    // 直至遍历到的节点的值不为val
                    int val = p.next.val;
                    //然后遍历把所有重复的全跳过
                    while(p.next != null && p.next.val == val){
                        p.next = p.next.next;
                    }
                }else{
                    p = p.next;
                }
            }
            return head.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}