//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package lc.linked_list;

import dataStructure.linked_list.ListNode;

/**
 * https://www.nowcoder.com/discuss/196944
 */
public class AddTwoNumbers_2 {
	public static void main(String[] args) {
		Solution solution = new AddTwoNumbers_2().new Solution();
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
        // 创建结果链表的头节点，默认该节点中的value为-1
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            // 进位标识carry，默认为0
            int carry = 0;
            // 遍历链表，当两个链表都为空时，退出
            while(l1 != null || l2 != null){
                // 判断该节点是否为空，当结点为空时，用0补齐；不为空时，加数即为节点的值
                int d1 = (l1 == null) ? 0 : l1.val;
                int d2 = (l2 == null) ? 0 : l2.val;
                // 对结点求和，注意：求和是需要考虑到进位
                int sum = d1 + d2 + carry;
                // 更新进位标识
                carry = (sum >= 10) ? 1 : 0;
                // sum%10标识求和的个位数，将其保存到结果链表中
                pre.next = new ListNode(sum % 10);
                pre = pre.next;
                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }

            // 重点，这是一个特殊情况，当两个链表计算完后，
            // 还需要判断进位标识是否为1，如果为1，如23+81=104，需要创建一个结点保存最高位
            if(carry == 1)
                pre.next = new ListNode(1);

            return dummy.next;
        }
	}
//leetcode submit region end(Prohibit modification and deletion)

}