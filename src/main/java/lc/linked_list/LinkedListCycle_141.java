//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针

  package lc.linked_list;

import dataStructure.linked_list.ListNode;

/***
 * 思路 俩指针，快的一次走2格子，慢的一次走1格子。最后如果快的慢的能重合代表有环。
 */
public class LinkedListCycle_141 {
      public static void main(String[] args) {
           Solution solution = new LinkedListCycle_141().new Solution();
          int[] nums = {3,2,0,-4};
          System.out.println(nums);
          ListNode listNode = new ListNode(nums);
          boolean b = solution.hasCycle(listNode);
          System.out.println(b);
      }

      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow = head;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }