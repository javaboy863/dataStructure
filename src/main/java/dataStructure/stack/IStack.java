package dataStructure.stack;

public interface IStack<E> {
	int getSize();

	boolean isEmpty();

	void push(E e);

	E pop();

	E peek();

}
