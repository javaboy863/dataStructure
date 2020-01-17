package dataStructure.map;

public class ListNodeMap<K,V> implements Map<K,V> {

	private class Node {
		public K key;
		public V value;
		public Node next;

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public Node() {
			this.key = null;
			this.value = null;
			this.next = null;
		}

		@Override
		public String toString() {
			return key.toString() + " : " + value.toString();
		}

	}


	private Node dummyHead;
	private int size;

	public ListNodeMap() {
		dummyHead = new Node();
		size = 0;
	}

	private Node getNode(K key) {
		Node dummyHead = this.dummyHead;
		Node currentNode = dummyHead.next;
		while (currentNode != null) {
			if (currentNode.key.equals(key)) {
				return currentNode;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	@Override
	public void add(K key, V value) {
		Node node = this.getNode(key);
		if (node == null) {
			dummyHead.next = new Node(key, value, dummyHead.next);
			size++;
		} else {
			node.value = value;
		}

	}

	@Override
	public boolean contains(K key) {
		return getNode(key) != null;
	}

	@Override
	public V get(K key) {
		Node node = this.getNode(key);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V newValue) {
		Node node = getNode(key);
		if (node == null) {
			throw new IllegalArgumentException(key + " doesn't exist!");
		}
		node.value = newValue;
	}

	@Override
	public V remove(K key) {
		Node prev = dummyHead;
		while (prev.next != null) {
			if (prev.next.key.equals(key)) {
				break;
			}
			prev = prev.next;
		}
		if (prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			size--;
			return delNode.value;
		}
		return null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		Node dummyHead = this.dummyHead;
		Node currentNode = dummyHead.next;
		StringBuilder sb = new StringBuilder();
		while (currentNode != null) {
			sb.append(currentNode);
			currentNode = currentNode.next;
			if (currentNode != null){
				sb.append(",");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ListNodeMap<Integer,String> listNodeMap = new ListNodeMap();
		for (int i = 0; i < 10; i++) {
			listNodeMap.add(i,i+"");
		}
		listNodeMap.remove(2);
		listNodeMap.remove(3);

		System.out.println(listNodeMap);
	}
}
