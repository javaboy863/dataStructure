//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针

  package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * 算法思想：其实这完全可以理解为一个数学问题，
 * 如果k<链表长度，实际上可以理解为把链表的后k个节点整块移到链表的前端，
 * 如果k>length，经过数学研究发现，实际上可以将 k=k%length,继续上边的操作。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateList_61 {
      public static void main(String[] args) {
           Solution solution = new RotateList_61().new Solution();
          ListNode listNode = new ListNode(new int[]{1,2,3,4,5});
           solution.rotateRight(listNode,2);
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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0)
            return head;
        if(head==null)
            return head;
        //长度从1开始
        int length=1;
        ListNode cur=head;
        while(cur.next!=null)
        {
            cur=cur.next;
            length++;
        }
        //已经把链表首尾相接的连上了，组成了环，这个是关键1->2->3->4->5->1
        cur.next=head;
        //这个是算法的关键，找到应该在何处断开
        int m=length-k%length;
        //找到K的地方
        for(int i=0;i<m;i++)
        {
            cur=cur.next;
        }
        //获得新的链表头节点，4->5->1->2->3
        ListNode newhead=cur.next;
        //cur.next正好是原来的尾部，这样做就断开了链表环
        cur.next=null;
        return newhead;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }