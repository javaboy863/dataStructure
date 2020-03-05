package dataStructure.linked_list;

/**
 * leetcode 单链版
 */
public class ListNode {

	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode(int[] nums) {
		ListNode target = new ListNode(nums[0]);
		ListNode head = target;
		for (int i = 1; i < nums.length; i++) {
			target.next = new ListNode(nums[i]);
			target = target.next;
		}
		this.val = head.val;
		this.next = head.next;
	}
	/*@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		ListNode cur = this;
		//只要拿到的元素不等于空
		while(cur.next != null){
			res.append(cur.val + "->");
			//拿元素的下一个元素指向当前
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}*/

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4};
		ListNode Node = new ListNode(nums);
		System.out.println(Node);
	}

}
