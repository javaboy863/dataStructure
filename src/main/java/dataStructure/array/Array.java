package dataStructure.array;


public class Array<E> {

	private int size;
	private E[] data;

	public Array(int capacity){
		data = (E[])new Object[capacity];
		this.size=0;
	}

	public Array(){
		this(10);
	}

	public void add(int index,E e){
		if (index > size || index < 0){
			throw new IllegalArgumentException("err index");
		}
		if (size == data.length){
			resize(2*data.length);
		}
		//从最后位置开始，到index位置，所有元素往后挪动一位
		for(int i = size - 1; i >= index ; i --){
			data[i + 1] = data[i];
		}
		//最后index位置替换成元素
		data[index] = e;
		size++;
	}

	/**
	 * 判断边界后，index之后的元素都前移动
	 */
	private E remove(int index) {
		if (index >= size || index < 0){
			throw new IllegalArgumentException("err index");
		}
		E ret = data[index];
		//从index往后的元素，都往左边移动
		for (int i = index+1; i < size; i++) {
			data[i-1]=data[i];
		}
		size--;
		//缩容
		if (size == data.length/4 && data.length/2 != 0){
			resize(data.length/2);
		}
		return ret;
	}


	/**
	 * 构建一个新数组，遍历老数组，数据给新数组
	 */
	private void resize(int capacity){
		E[] newData = (E[])new Object[capacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)){
				return i;
			}
		}
		return -1;
	}


	/**重要的方法分割线，上面都是重要的方法。 **/


	public void addLast(E e) {
		add(size,e);
	}

	public void addFirst(E e) {
		add(0,e);
	}

	public E get(int index) {
		if (index >= size || index < 0){
			throw new IllegalArgumentException("err index");
		}
		return this.data[index];
	}

	public E getFirst() {
		return get(0);
	}

	public E getLast() {
		return get(size-1);
	}



	public int getCapacity() {
		return this.data.length;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public void set(int index,E e) {
		if (index > size || index < 0){
			throw new IllegalArgumentException("err index");
		}
		this.data[index] = e;
	}

	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)){
				return true;
			}
		}
		return false;
	}

	public E removeFirst() {
		return this.remove(0);
	}

	public E removeElement(E e) {
		int index = find(e);
		if (index == -1){
			return null;
		}
		return this.remove(index);
	}

	public E removeLast() {
		//size元素就越界了，所以size-1。
		return this.remove(size-1);
	}



	@Override
	public String toString(){

		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
		res.append('[');
		for(int i = 0 ; i < size ; i ++){
			res.append(data[i]);
			if(i != size - 1){
				res.append(", ");
			}
		}
		res.append(']');
		return res.toString();
	}

	public static void main(String[] args) {

		Array<Integer> arr = new Array<>();
		for(int i = 0 ; i < 10 ; i ++)
			arr.addLast(i);
		System.out.println(arr);

		arr.add(1, 100);
		System.out.println(arr);

		arr.addFirst(-1);
		System.out.println(arr);

		arr.remove(2);
		System.out.println(arr);

		arr.removeElement(4);
		System.out.println(arr);

		arr.removeFirst();
		System.out.println(arr);

		for(int i = 0 ; i < 4 ; i ++){
			arr.removeFirst();
			System.out.println(arr);
		}
	}
}
