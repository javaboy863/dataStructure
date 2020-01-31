//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

  package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * 21. 合并两个有序链表
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 思路：
 * https://www.bilibili.com/video/av27108858?from=search&seid=7515068401455893484
 * 【1,2,4】 【1,3,4】
 * 1、1+merge([1,2,4],[3,4])
 * 2、1+merge([2,4],[3,4])
 * 3、2+merge([4],[3,4])
 * 4、3+merge([4],[4])
 * 5、4+merge([null],[4])
 * 6、递归开始返回非空的l2:4->null
 * 7、4->4->null
 * 8、3->4->4->null
 * 9、2->3->4->4->null
 * 10、1->2->3->4->4->null
 * 11、1->1->2->3->4->4->null 完成
 */
public class MergeTwoSortedLists_21 {
      public static void main(String[] args) {
           Solution solution = new MergeTwoSortedLists_21().new Solution();
          int[] nums = {1,2,4};
          ListNode listNode = new ListNode(nums);
          int[] nums2 = {1,3,4};
          ListNode listNode2 = new ListNode(nums2);
          ListNode lists  = solution.mergeTwoLists(listNode,listNode2);
          System.out.println(lists);
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //这里最后返回的是剩下没遍历完的链表，然后返回跟之前的小的链接，这样直到整个链表出来了
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val<l2.val){
            //每次找出最小的，然后用剩下（子链表）去比较。
            l1.next = mergeTwoLists(l1.next,l2);
            //返回接收后的自身
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }