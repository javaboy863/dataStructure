package lc.linked_list;


import dataStructure.linked_list.Node;

public class lc_206_ReverseList {

	/**
	 * 题目：反转数组，保持链表值不变，只是next反转
	 * 思路：定义pre，cur，next三个指针。pre一开始是null。cur=当前的head，next等于head.next。初始化完毕。
	 * 然后cur.next指向pre，完成当前节点的指针变动。然后移动定义的三个指针：pre后移指向cur，cur指向next，next指向cur.next
	 *
	 */
	public static Node reverse(Node head ){
		Node pre = null;
		Node cur=head;
		while (cur != null){
			Node next = cur.next;
			//开始移动
			pre=cur;
			cur=next;
			next=cur;
			//完毕
		}
		return head;
	}

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4};
		Node Node = new Node(nums);
		while (Node.next !=null){
			System.out.println(Node.val);
			Node =Node.next;
		}
	}





}