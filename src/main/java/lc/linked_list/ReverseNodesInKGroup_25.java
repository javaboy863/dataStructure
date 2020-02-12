//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 示例 : 
//
// 给定这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 说明 : 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
// 
// Related Topics 链表

package lc.linked_list;

import dataStructure.linked_list.ListNode;

public class ReverseNodesInKGroup_25 {
	public static void main(String[] args) {
		Solution solution = new ReverseNodesInKGroup_25().new Solution();
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
		public ListNode reverseKGroup(ListNode head, int k) {
		    //pre前继节点
            ListNode pre = null;
            ListNode cur = head;//当前节点
            ListNode next = head;//后继节点
            ListNode sum = head;//用来计算是否有K个节点的遍历
            int count = 0;
            int i = 0;
            //计算链表长度
            while (sum != null){
                sum = sum.next;
                count++;
            }
            if(count < k){
                return head;
            }else {
                //对每一组进行翻转
                while (i < k && cur != null){
                    next = cur.next;//记录下一个节点
                    //翻转节点
                    cur.next = pre;//当前节点的下一个节点指向前继节点
                    pre = cur;//当前节点变成前继节点
                    cur = next;//下一个节点变成当前节点
                    //该while完成后，该组的翻转就完成了，pre就会指向原本的最后一个节点，翻转之后的第一个节点。head节点就变成了翻转之后的最后一个节点
                    i++;
                }
                //如果next节点不为空，即后面还有节点
                if(next != null){
                    //递归
                    head.next =  reverseKGroup(next, k);
                }
                return pre;
            }
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}