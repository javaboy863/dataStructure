package dataStructure.linked_list;

/**
 * 单链表，只有一个指向next的指针
 */
public class linkedNode<E> {

	private class Node{
		public E data;
		public Node next;

		public Node(E data, Node next){
			this.data = data;
			this.next = next;
		}

		public Node(E data){
			this(data, null);
		}

		public Node(){
			this(null, null);
		}

		@Override
		public String toString(){
			if (data !=null){
				return data.toString();
			}
			return "";
		}
	}

	private Node dummyHead;
	private int size;

	public linkedNode(){
		dummyHead = new Node();
		this.size = 0;
	}

	public linkedNode(E[] nums){
		dummyHead = new Node();
		if (nums == null){
			throw new IllegalArgumentException("error nums...");
		}
		for (int i = 0; i < nums.length; i++) {
			add(i, nums[i]);
		}
	}


	public E get(int index){
		if (index < 0 || index >size){
			throw new IllegalArgumentException("index error...");
		}
		Node root = this.dummyHead.next;
		for (int i = 0; i < index; i++) {
			root = root.next;
		}
		return root.data;
	}


	public void add(int index,E data){
		//边界，这里index可以是size是因为要插入最后。
		if (index < 0 || index >size){
			throw new IllegalArgumentException("index error...");
		}
		Node prev = this.dummyHead;
		//因为有了dummy节点，所以取到的是实际容量的前一个元素
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		//新node的下一个是原来元素的下一个。
		Node node = new Node(data,prev.next);
		//把原来元素下一个指向新node
		prev.next = node;
		size++;
	}


	/**
	 * 找到要删除元素的前一个元素，这个元素的next指向要删除元素的next即完成。
	 */
	public E remove(int index){
		//注意边界，不能删除index >=size的，这里索引是从0开始的，size比索引大于1.
		if (index < 0 || index >=size){
			throw new IllegalArgumentException("index error...");
		}
		Node prve = this.dummyHead;
		//应为有了dummy元素，所以取到的是前一个元素
		for (int i = 0; i < index; i++) {
			prve = prve.next;
		}
		//拿到要删除元素的前一个元素
		Node retNode = prve.next;
		//要删除元素的下一个元素跟前一个元素的下一个元素相连。
		prve.next = retNode.next;
		//要删除的元素置空
		retNode.next = null;
		size--;
		return retNode.data;
	}

	/**重要的方法分割线，上面都是重要的方法。 **/

	public int getSize(){
		return size;
	}
	public int getNext(){
		return this.getNext();
	}

	public boolean isEmpty(){
		return size==0;
	}
	public void set(int index, E e){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Set failed. Illegal index.");
		}

		Node cur = dummyHead.next;
		for(int i = 0 ; i < index ; i ++){
			cur = cur.next;
		}
		cur.data = e;
	}

	/**
	 * 头部加元素
	 */
	public void addFirst(E data){
		this.add(0,data);
	}

	/**
	 * 尾部加元素
	 */
	public void addLast(E data){
		this.add(size,data);
	}



	public E getFirst(){
		return get(0);
	}

	public E getLast(){
		return get(size-1);
	}

	public boolean contains(E data){
		Node cur = this.dummyHead.next;
		while (cur != null){
			if (cur.data.equals(data)){
				return true;
			}
			cur = cur.next;
		}
		return false;
	}


	public E removeFirst() {
		return this.remove(0);
	}

	public E removeLast(){
		return this.remove(size-1);
	}

	public void removeElement(E data){
		Node prev = this.dummyHead;
		//这里查找的是prev的next元素，是为了获取要删除元素的前一个元素
		while (prev.next != null){
			if (prev.next.data.equals(data)){
				break;
			}
			prev = prev.next  ;
		}
		//进行删除逻辑
		if (prev.next != null){
			Node retNode = prev.next;
			prev.next = retNode.next;
			retNode =null;
			size--;
		}
	}

	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		Node cur = this.dummyHead.next;
		//只要拿到的元素不等于空
		while(cur != null){
			res.append(cur + "->");
			//拿元素的下一个元素指向当前
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}

	public static void main(String[] args) {
		linkedNode<Integer> listNode = new linkedNode<>();
		for(int i = 0 ; i < 5 ; i ++){
			listNode.addLast(i);
			System.out.println(listNode);
		}
		listNode.add(2, 666);
		listNode.add(5, 777);
		System.out.println(listNode);
		System.out.println(listNode.contains(777));
		listNode.remove(2);
		listNode.removeElement(777);
		System.out.println(listNode);
	}

}
