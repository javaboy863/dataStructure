//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。 
//
// 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 进阶: 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 示例: 
//
// 
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
// 
// Related Topics 链表

package lc.linked_list;

import dataStructure.linked_list.ListNode;

import java.util.Stack;

/**
 * 如果不希望改变链表的结构，那么用什么方式来将链表中的元素按照倒序读取呢？
 * 这时候就可以很快的联想到栈这个结构。通过栈可以实现先进后出，即读取顺序的转置。
 */
public class AddTwoNumbersIi_445 {
	public static void main(String[] args) {
		Solution solution = new AddTwoNumbersIi_445().new Solution();
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
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			Stack<Integer> s1 = new Stack<Integer>();
			Stack<Integer> s2 = new Stack<Integer>();
			while (l1 != null) {
				s1.push(l1.val);
				l1 = l1.next;
			}
			while (l2 != null) {
				s2.push(l2.val);
				l2 = l2.next;
			}

			int carry = 0;
			ListNode result = new ListNode(0);
			while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
				int add = (s1.isEmpty() ? 0 : s1.pop())
						+ (s2.isEmpty() ? 0 : s2.pop())
						+ carry;
				carry = add / 10;
				ListNode tmp = new ListNode(add % 10);
				//新节点的下一个 指向resukt.next
				tmp.next = result.next;
				//result的下一个是新节点
				result.next = tmp;
			}
			return result.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}