package dataStructure.linked_list;

/**
 * leetcode 单链版
 */
public class Node {

	public int val;
	public Node next;
	Node(int x) {
		val = x;
		next = null;
	}

	public Node(int[] nums) {
		Node target = new Node(nums[0]);
		Node head = target;
		for (int i = 1; i < nums.length; i++) {
			target.next = new Node(nums[i]);
			target = target.next;
		}
		this.val = head.val;
		this.next = head.next;
	}
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		Node cur = this;
		//只要拿到的元素不等于空
		while(cur != null){
			res.append(cur.val + "->");
			//拿元素的下一个元素指向当前
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4};
		Node Node = new Node(nums);
		System.out.println(Node);
	}

}
