//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。 
//
// 现有一个链表 -- head = [4,5,1,9]，它可以表示为: 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], node = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], node = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明: 
//
// 
// 链表至少包含两个节点。 
// 链表中所有节点的值都是唯一的。 
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。 
// 不要从你的函数中返回任何结果。 
// 
// Related Topics 链表

package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * 因为拿不到要删除节点的前一个节点，所以只能把下个节点复制给当前节点，然后干掉下个节点
 */
public class DeleteNodeInALinkedList_237 {
	public static void main(String[] args) {
		Solution solution = new DeleteNodeInALinkedList_237().new Solution();
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
		public void deleteNode(ListNode node) {
            if (node ==null || node.next ==null){
                return;
            }
            //把下个节点的值给当前节点
            node.val = node.next.val;
            ListNode delNode = node.next;
            //当前节点指向下下个节点，因为前面把下个节点的值拿到了。所以下个节点就不需要了
            node.next = delNode.next;

        }
	}
//leetcode submit region end(Prohibit modification and deletion)

}