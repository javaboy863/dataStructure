//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表

package lc.linked_list;

import dataStructure.linked_list.ListNode;

public class RemoveLinkedListElements_203 {
	public static void main(String[] args) {
		Solution solution = new RemoveLinkedListElements_203().new Solution();
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
		public ListNode removeElements(ListNode head, int val) {
		    //虚拟节点
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode cur = dummyHead;
            while (cur.next != null ){
                if (cur.next.val == val){
                    //要删除的节点
                    ListNode delNode = cur.next;
                    //当前的下一个指向要删除的下一个
                    cur.next = delNode.next;
                }else {
                    //不是的话继续找下一个
                    cur = cur.next;
                }
            }
            return dummyHead.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}