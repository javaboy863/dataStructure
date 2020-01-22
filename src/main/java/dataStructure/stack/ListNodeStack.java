package dataStructure.stack;

import dataStructure.linked_list.linkedNode;

/**
 * 链表实现的栈 ，先进后出
 * 应用：系统调用栈，撤销回退
 */
public class ListNodeStack<E> implements Stack<E> {
	private linkedNode<E> listNode;

	public ListNodeStack(){
		listNode = new linkedNode<>();
	}

	@Override
	public int getSize() {
		return listNode.getSize();
	}

	@Override
	public boolean isEmpty() {
		return listNode.isEmpty();
	}

	@Override
	public void push(E o) {
		listNode.addFirst(o);
	}

	@Override
	public E pop() {
		return listNode.removeFirst();
	}

	@Override
	public E peek() {
		return listNode.getFirst();
	}

	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("Stack: ");
		res.append('[');
		for(int i = 0; i < listNode.getSize() ; i ++){
			res.append(listNode.get(i));
			if(i != listNode.getSize() - 1)
				res.append(", ");
		}
		res.append("] top");
		return res.toString();
	}

	public static void main(String[] args) {
		ListNodeStack<Integer> arrayStack = new ListNodeStack();
		for (int i = 0; i < 5; i++) {
			arrayStack.push(i);
		}
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack);

	}
}
