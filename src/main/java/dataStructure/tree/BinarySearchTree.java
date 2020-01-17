package dataStructure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * 二分搜索树
 */
public class BinarySearchTree<E extends Comparable> {

	private class Node {
		Node left, right;
		E data;

		public Node(E e) {
			this.left = left;
			this.right = right;
			this.data = e;
		}

	}

	private Node root;
	private int size;

	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * 递归添加
	 */
	private Node add(Node node, E e) {
		//终止条件，直到某个元素的节点是null的，如果节点是null直接new新的
		if (node == null) {
			node = new Node(e);
			size++;
			return node;
		}
		//小的放左边
		if (node.data.compareTo(e) < 0) {
			node.left = add(node.left, e);
		} else if (node.data.compareTo(e) > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}

	// 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
	// 返回删除节点后新的二分搜索树的根
	private Node remove(Node node, E e) {
		if (node == null){
			return null;
		}
		//递归找
		if (e.compareTo(node.data) > 0){
			node.right = remove(node.right, e);
			return node;
		}else if (e.compareTo(node.data) < 0){
			node.left = remove(node.left, e);
			return node;
		}else {
			//找到了的情况
			// 待删除节点左子树为空的情况
			if (node.left ==null){
				Node right = node.right;
				node.right=null;
				size--;
				return right;
			}

			if (node.right ==null){
				Node left = node.left;
				node.left=null;
				size--;
				return left;
			}

			// 待删除节点左右子树均不为空的情况
			// 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
			// 用这个节点顶替待删除节点的位置
			Node sucessDel = minimum(node.right);
			sucessDel.right = removeMin(node.right);
			sucessDel.left = node.left;
			node.left = node.right = null;
			return sucessDel;
		}
	}

	public void remove(E data) {
		this.remove(root,data);
	}

	public void preOrder(){
		preOrder(root);
	}
	public void inOrder(){
		inOrder(root);
	}
	public void postOrder(){
		postOrder(root);
	}

	/**
	 * 前序遍历
	 */
	private void preOrder(Node node) {
		if (node == null){
			return;
		}
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	/**
	 * 中序遍历
	 */
	private void inOrder(Node node) {
		if (node == null){
			return;
		}
		preOrder(node.left);
		System.out.println(node.data);
		preOrder(node.right);
	}

	/**
	 * 后序遍历
	 */
	private void postOrder(Node node) {
		if (node == null){
			return;
		}
		preOrder(node.left);
		preOrder(node.right);
		System.out.println(node.data);
	}

	/**
	 * 层次遍历
	 */
	public void levelOrder(){
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()){
			Node node = queue.remove();
			System.out.println(node.data);
			if (node.left != null){
				queue.add(node.left);
			}
			if (node.right != null){
				queue.add(node.right);
			}
		}

	}

	private E removeMin(Node node, E e) {
		E minimum = minimum();
		root = removeMin(root);
		return minimum;
	}

	// 删除掉以node为根的二分搜索树中的最小节点
	// 返回删除节点后新的二分搜索树的根
	private Node removeMin(Node node) {
		if (node.left ==null){
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	private E removeMax(Node node, E e) {
		E maximum = maximum();
		root = removeMax(root);
		return maximum;
	}

	// 删除掉以node为根的二分搜索树中的最大节点
	// 返回删除节点后新的二分搜索树的根
	private Node removeMax(Node node) {
		//直到找到右子节点为空的代表找到了最大的节点，同时把要删除节点的左节点返回
		if (node.right ==null){
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		//同时把右节点指向新的左节点
		node.right = removeMin(node.right);
		return node;
	}

	private boolean contains(Node node, E e) {
		if (node == null) {
			return false;
		}
		//递归
		if (node.data.compareTo(e) == 1) {
			return true;
		} else if (node.data.compareTo(e) < 0) {
			return contains(node.left, e);
		} else if (node.data.compareTo(e) > 0) {
			return contains(node.right, e);
		}
		return false;
	}

	/**
	 * 从 root 开始查
	 */
	public boolean contains(E e) {
		return this.contains(root, e);
	}

	/**
	 * 寻找最小的元素
	 */
	public E minimum() {
		if (size == 0) {
			throw new IllegalArgumentException("BST is empty!");
		}
		return minimum(root).data;
	}

	/**
	 * 递归一直从最左边找
	 */
	private Node minimum(Node node) {
		//终止条件，直到左子节点为空
		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}

	/**
	 * 递归找右边的，因为右边的都比当前节点大
	 */
	public E maximum() {
		if (size == 0) {
			throw new IllegalArgumentException("BST is empty!");
		}
		return maximum(root).data;
	}

	private Node maximum(Node node) {
		if (node.right == null) {
			return node;
		}
		return minimum(node.right);
	}


	public void add(E e) {
		//从根root开始
		root = this.add(root, e);
	}


	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}


	// 生成以node为根节点，深度为depth的描述二叉树的字符串
	private void generateBSTString(Node node, int depth, StringBuilder res) {

		if (node == null) {
			res.append(generateDepthString(depth) + "null\n");
			return;
		}

		res.append(generateDepthString(depth) + node.data + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");
		}
		return res.toString();
	}

	// 打乱数组顺序
	private static void shuffle(Object[] arr) {

		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = (int) (Math.random() * (i + 1));
			Object t = arr[pos];
			arr[pos] = arr[i];
			arr[i] = t;
		}
	}

	public static void main(String[] args) {

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		Random random = new Random();
		int n = 10;
		for (int i = 0; i < n; i++)
			bst.add(random.nextInt(n));
		// 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的
		// order数组中存放[0...n)的所有元素
//		Integer[] order = new Integer[n];
//		for( int i = 0 ; i < n ; i ++ )
//			order[i] = i;
		// 打乱order数组的顺序
//		shuffle(order);

		// 乱序删除[0...n)范围里的所有元素
//		for( int i = 0 ; i < n ; i ++ )
//			if(bst.contains(order[i])){
//				bst.remove(order[i]);
//				System.out.println("After remove " + order[i] + ", size = " + bst.size() );
//			}

		// 最终整个二分搜索树应该为空
		System.out.println(bst);
		bst.levelOrder();
	}

}
