//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

  package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs_24 {
      public static void main(String[] args) {
           Solution solution = new SwapNodesInPairs_24().new Solution();
          int[] nums = {1,2,3,4};
          ListNode listNode = new ListNode(nums);
          System.out.println(solution.swapPairs(listNode));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //dummy-> 1->2->3->4         dummy->2->1->4->3
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        //只要下一个和下一个的下一个不等于空
        while (cur.next != null && cur.next.next != null){
            //两两指针里面的1
            ListNode next = cur.next;
            //两两指针里面的2
            ListNode nextNext = cur.next.next;
            //1的下一个指向3
            next.next = nextNext.next;
            //2的下一个指向1
            nextNext.next = next;
            //当前节点(从dummy开始的)的下一个指向2
            cur.next = nextNext;
            //当前节点向前挑两个,至此完成了一轮交换
            cur = cur.next.next;
        }

        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }