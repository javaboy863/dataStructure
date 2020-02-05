//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

  package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * 思路：设置一个变量，记录下链表中第一次出现大于等于值x结点的位置insertPos。之后遍历链表，将所有小于值x的结点提到这个位置上；
 */
public class PartitionList_86 {
      public static void main(String[] args) {
           Solution solution = new PartitionList_86().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        //当前节点的上一个节点
        ListNode pre=dummyHead;
        //当前节点
        ListNode cur=head;
        ListNode insertPos=null;
        while(cur!=null){
            //定位需要插入的位置;
            if(cur.val>=x && insertPos==null){
                //insertPos等于大于x的元素的前一个元素
                insertPos=pre;
            }
            //插入操作;
            //Given 1->4->3->2->5->2 and x = 3,
            //return 1->2->2->4->3->5.
            if(cur.val<x && insertPos!=null){
                //需要注意的是，提取结点时的操作：
                // 1.当前结点的上一个结点的next指向当前结点的next；3->5->2
                pre.next=pre.next.next;
                // 2.当前结点的next指向insertPos的next，insertPos的next指向当前结点； 2->4->...
                cur.next=insertPos.next;
                //3.插入位置的下一个是当前小于x的
                insertPos.next=cur;
                //因为插入完了，所以移动插入位置的指针到插入后的下一个
                insertPos=insertPos.next;
                //移动当前元素的指针到前一个指针的下一个指针
                cur=pre.next;
                //这里就不走if下面的pre 和cur指针next了
                continue;
            }
            pre=pre.next;
            cur=cur.next;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }