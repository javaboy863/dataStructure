package dataStructure.set;

import dataStructure.linked_list.linkedNode;

public class ListNodeSet<E> implements Set<E> {

	private linkedNode<E> listNode;

	public ListNodeSet(){
		listNode = new linkedNode<>();
	}

	@Override
	public void add(E e) {
		if (!listNode.contains(e)){
			listNode.addFirst(e);
		}
	}

	@Override
	public boolean contains(E e) {
		return listNode.contains(e);
	}

	@Override
	public void remove(E e) {
		listNode.removeElement(e);
	}

	@Override
	public int getSize() {
		return listNode.getSize();
	}

	@Override
	public boolean isEmpty() {
		return listNode.isEmpty();
	}

	public static void main(String[] args) {
		ListNodeSet listnodeSet = new ListNodeSet();
		for (int i = 0; i < 10; i++) {
			listnodeSet.add(i);
		}
		for (int i = 0; i < 10; i++) {
			listnodeSet.add(i);
		}

		System.out.println(listnodeSet.getSize());

	}
}
