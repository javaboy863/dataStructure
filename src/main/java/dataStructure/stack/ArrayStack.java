package dataStructure.stack;

import dataStructure.array.Array;

/**
 * 数组实现的栈 ，先进后出
 * 应用：系统调用栈，撤销回退
 */
public class ArrayStack<E> implements Stack<E> {
	private Array<E> array;

	public ArrayStack(){
		array = new Array();
	}
	public ArrayStack(int size){
		array = new Array(size);
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void push(E o) {
		array.addLast(o);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("Stack: ");
		res.append('[');
		for(int i = 0 ; i < array.getSize() ; i ++){
			res.append(array.get(i));
			if(i != array.getSize() - 1)
				res.append(", ");
		}
		res.append("] top");
		return res.toString();
	}

	public static void main(String[] args) {
		ArrayStack<Integer> arrayStack = new ArrayStack();
		for (int i = 0; i < 5; i++) {
			arrayStack.push(i);
		}
		System.out.println(arrayStack);
		System.out.println(arrayStack.peek());

	}
}
