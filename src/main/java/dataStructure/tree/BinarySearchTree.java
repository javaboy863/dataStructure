package dataStructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 由于Key需要能够进行比较，所以需要extends Comparable<Key>
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	// 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
	private class Node {
		private Key key;
		private Value value;
		private Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			left = right = null;
		}

		public Node(Node node) {
			this.key = node.key;
			this.value = node.value;
			this.left = node.left;
			this.right = node.right;
		}
	}

	private Node root;  // 根节点
	private int count;  // 树种的节点个数

	// 构造函数, 默认构造一棵空二分搜索树
	public BinarySearchTree() {
		root = null;
		count = 0;
	}

	// 返回二分搜索树的节点个数
	public int size() {
		return count;
	}

	// 返回二分搜索树是否为空
	public boolean isEmpty() {
		return count == 0;
	}

	// 向二分搜索树中插入一个新的(key, value)数据对
	public void insert(Key key, Value value) {
		root = insert(root, key, value);
	}

	// 查看二分搜索树中是否存在键key
	public boolean contain(Key key) {
		return contain(root, key);
	}

	// 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
	public Value search(Key key) {
		Node node = search(root, key);
		return node == null ? null : node.value;
	}

	// 二分搜索树的前序遍历
	public void preOrder() {
		preOrder(root);
	}

	// 二分搜索树的中序遍历
	public void inOrder() {
		inOrder(root);
	}

	// 二分搜索树的后序遍历
	public void postOrder() {
		postOrder(root);
	}

	// 二分搜索树的层序遍历
	public void levelOrder() {

		// 我们使用LinkedList来作为我们的队列
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {

			Node node = q.remove();

			System.out.println(node.key);

			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}

	// 寻找二分搜索树的最小的键值
	public Key minimum() {
		assert count != 0;
		Node minNode = minimum(root);
		return minNode.key;
	}

	// 寻找二分搜索树的最大的键值
	public Key maximum() {
		assert count != 0;
		Node maxNode = maximum(root);
		return maxNode.key;
	}

	// 从二分搜索树中删除最小值所在节点
	public void removeMin() {
		if (root != null)
			root = removeMin(root);
	}

	// 从二分搜索树中删除最大值所在节点
	public void removeMax() {
		if (root != null)
			root = removeMax(root);
	}

	// 从二分搜索树中删除键值为key的节点
	public void remove(Key key) {
		root = remove(root, key);
	}

	// 寻找key的floor值, 递归算法
	// 如果不存在key的floor值(key比BST中的最小值还小), 返回NULL
	public Key floor(Key key) {

		if (count == 0 || key.compareTo(minimum()) < 0)
			return null;

		Node floorNode = floor(root, key);
		return floorNode.key;
	}

	// 寻找key的ceil值, 递归算法
	// 如果不存在key的ceil值(key比BST中的最大值还大), 返回NULL
	public Key ceil(Key key) {

		if (count == 0 || key.compareTo(maximum()) > 0)
			return null;

		Node ceilNode = ceil(root, key);
		return ceilNode.key;
	}

	// 查找key的前驱 ,小于Key的最大的节点
	// 如果不存在key的前驱(key不存在, 或者key是整棵二叉树中的最小值), 则返回NULL
	public Key predecessor(Key key) {
		Node node = search(root, key);
		// 如果key所在的节点不存在, 则key没有前驱, 返回NULL
		if (node == null)
			return null;

		// 如果key所在的节点左子树不为空,则其左子树的最大值为key的前驱
		if (node.left != null)
			return maximum(node.left).key;

		// 否则, key的前驱在从根节点到key的路径上, 在这个路径上寻找到比key小的最大值, 即为key的前驱
		Node preNode = predecessorFromAncestor(root, key);
		return preNode == null ? null : preNode.key;
	}

	// 查找key的后继, 递归算法，大于key的最小的节点
	// 如果不存在key的后继(key不存在, 或者key是整棵二叉树中的最大值), 则返回NULL
	public Key successor(Key key) {

		Node node = search(root, key);
		// 如果key所在的节点不存在, 则key没有前驱, 返回NULL
		if (node == null)
			return null;

		// 如果key所在的节点右子树不为空,则其右子树的最小值为key的后继
		if (node.right != null)
			return minimum(node.right).key;

		// 否则, key的后继在从根节点到key的路径上, 在这个路径上寻找到比key大的最小值, 即为key的后继
		Node sucNode = successorFromAncestor(root, key);
		return sucNode == null ? null : sucNode.key;
	}

	//********************
	//* 二分搜索树的辅助函数
	//********************

	// 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
	// 返回插入新节点后的二分搜索树的根
	private Node insert(Node node, Key key, Value value) {

		if (node == null) {
			count++;
			return new Node(key, value);
		}

		if (key.compareTo(node.key) == 0)
			node.value = value;
		else if (key.compareTo(node.key) < 0)
			node.left = insert(node.left, key, value);
		else    // key > node->key
			node.right = insert(node.right, key, value);

		return node;
	}

	// 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
	private boolean contain(Node node, Key key) {

		if (node == null)
			return false;

		if (key.compareTo(node.key) == 0)
			return true;
		else if (key.compareTo(node.key) < 0)
			return contain(node.left, key);
		else // key > node->key
			return contain(node.right, key);
	}

	// 在以node为根的二分搜索树中查找key所对应的value, 递归算法
	// 若value不存在, 则返回NULL
	private Node search(Node node, Key key) {

		if (node == null)
			return null;

		if (key.compareTo(node.key) == 0)
			return node;
		else if (key.compareTo(node.key) < 0)
			return search(node.left, key);
		else // key > node->key
			return search(node.right, key);
	}

	// 对以node为根的二叉搜索树进行前序遍历, 递归算法
	private void preOrder(Node node) {

		if (node != null) {
			System.out.println(node.key);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	// 对以node为根的二叉搜索树进行中序遍历, 递归算法
	private void inOrder(Node node) {

		if (node != null) {
			inOrder(node.left);
			System.out.println(node.key);
			inOrder(node.right);
		}
	}

	// 对以node为根的二叉搜索树进行后序遍历, 递归算法
	private void postOrder(Node node) {

		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.key);
		}
	}

	// 返回以node为根的二分搜索树的最小键值所在的节点
	private Node minimum(Node node) {
		if (node.left == null)
			return node;

		return minimum(node.left);
	}

	// 返回以node为根的二分搜索树的最大键值所在的节点
	private Node maximum(Node node) {
		if (node.right == null)
			return node;

		return maximum(node.right);
	}

	// 删除掉以node为根的二分搜索树中的最小节点
	// 返回删除节点后新的二分搜索树的根
	private Node removeMin(Node node) {

		if (node.left == null) {

			Node rightNode = node.right;
			node.right = null;
			count--;
			return rightNode;
		}

		node.left = removeMin(node.left);
		return node;
	}

	// 删除掉以node为根的二分搜索树中的最大节点
	// 返回删除节点后新的二分搜索树的根
	private Node removeMax(Node node) {

		if (node.right == null) {

			Node leftNode = node.left;
			node.left = null;
			count--;
			return leftNode;
		}

		node.right = removeMax(node.right);
		return node;
	}

	// 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
	// 返回删除节点后新的二分搜索树的根
	private Node remove(Node node, Key key) {

		if (node == null)
			return null;

		if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		} else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		} else {   // key == node->key

			// 待删除节点左子树为空的情况
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				count--;
				return rightNode;
			}

			// 待删除节点右子树为空的情况
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				count--;
				return leftNode;
			}

			/**
			 * 待删除节点左右子树均不为空的情况
			 * 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
			 * 用这个节点顶替待删除节点的位置
			 */
			//先找到node右子树节点的最小节点（比待删除节点大的最小节点）
			Node successor = new Node(minimum(node.right));
			count++;
			//在node的右子树中，把这个最小节点删除，然后会返回右子树，所以在关联上这个最小节点的右子树。
			successor.right = removeMin(node.right);
			successor.left = node.left;

			node.left = node.right = null;
			count--;

			return successor;
		}
	}

	// 在以node为根的二叉搜索树中, 寻找key的floor值所处的节点, 递归算法
	private Node floor(Node node, Key key) {

		if (node == null)
			return null;

		// 如果node的key值和要寻找的key值相等
		// 则node本身就是key的floor节点
		if (node.key.compareTo(key) == 0)
			return node;

		// 如果node的key值比要寻找的key值大
		// 则要寻找的key的floor节点一定在node的左子树中
		if (node.key.compareTo(key) > 0)
			return floor(node.left, key);

		// 如果node->key < key
		// 则node有可能是key的floor节点, 也有可能不是(存在比node->key大但是小于key的其余节点)
		// 需要尝试向node的右子树寻找一下
		Node tempNode = floor(node.right, key);
		if (tempNode != null)
			return tempNode;

		return node;
	}

	// 在以node为根的二叉搜索树中, 寻找key的ceil值所处的节点, 递归算法
	private Node ceil(Node node, Key key) {

		if (node == null)
			return null;

		// 如果node的key值和要寻找的key值相等
		// 则node本身就是key的ceil节点
		if (node.key.compareTo(key) == 0)
			return node;

		// 如果node的key值比要寻找的key值小
		// 则要寻找的key的ceil节点一定在node的右子树中
		if (node.key.compareTo(key) < 0)
			return ceil(node.right, key);

		// 如果node->key > key
		// 则node有可能是key的ceil节点, 也有可能不是(存在比node->key小但是大于key的其余节点)
		// 需要尝试向node的左子树寻找一下
		Node tempNode = ceil(node.left, key);
		if (tempNode != null)
			return tempNode;

		return node;
	}

	// 在以node为根的二叉搜索树中, 寻找key的祖先中,比key小的最大值所在节点, 递归算法
	// 算法调用前已保证key存在在以node为根的二叉树中
	Node predecessorFromAncestor(Node node, Key key) {

		if (node.key.compareTo(key) == 0)
			return null;

		if (key.compareTo(node.key) < 0)
			// 如果当前节点大于key, 则当前节点不可能是比key小的最大值
			// 向下搜索到的结果直接返回
			return predecessorFromAncestor(node.left, key);
		else {
			assert key.compareTo(node.key) > 0;
			// 如果当前节点小于key, 则当前节点有可能是比key小的最大值
			// 向右继续搜索, 将结果存储到tempNode中
			Node tempNode = predecessorFromAncestor(node.right, key);
			if (tempNode != null)
				return tempNode;
			else
				// 如果tempNode为空, 则当前节点即为结果
				return node;
		}
	}

	// 在以node为根的二叉搜索树中, 寻找key的祖先中,比key大的最小值所在节点, 递归算法
	// 算法调用前已保证key存在在以node为根的二叉树中
	Node successorFromAncestor(Node node, Key key) {

		if (node.key.compareTo(key) == 0)
			return null;

		if (key.compareTo(node.key) > 0)
			// 如果当前节点小于key, 则当前节点不可能是比key大的最小值
			// 向下搜索到的结果直接返回
			return successorFromAncestor(node.right, key);
		else {
			assert (key.compareTo(node.key) < 0);
			// 如果当前节点大于key, 则当前节点有可能是比key大的最小值
			// 向左继续搜索, 将结果存储到tempNode中
			Node tempNode = successorFromAncestor(node.left, key);
			if (tempNode != null)
				return tempNode;
			else
				// 如果tempNode为空, 则当前节点即为结果
				return node;
		}
	}
	// 打乱数组顺序
	private static void shuffle(ArrayList arr){

		for(int i = arr.size()-1 ; i >= 0 ; i --){
			int pos = (int) (Math.random() * (i+1));
			Object t = arr.get(pos);
			arr.set(pos, arr.get(i));
			arr.set(i, t);
		}
	}

	public static void main(String[] args) {

		// 生成 0 到 N-1 一共 N 个数字的数组
		int N = 100;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for( int i = 0 ; i < N ; i ++)
			nums.add(i);

		// 将数组中的数组乱序
		shuffle(nums);

		// 将这个N个数插入到二叉树中
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		for(Integer num: nums)
			bst.insert(num, num);

		// 测试前驱算法, 除了数字0没有前驱, 每个数字x的前驱应该为x-1
		for(int i = 0 ; i < N ; i ++) {
			if (i == 0) {
				assert bst.predecessor(i) == null;
				System.out.println("The predesessor of 0 is NULL");
			} else {
				assert bst.predecessor(i) == i - 1;
				System.out.println("The predesessor of " + i + " is " + (i - 1));
			}
		}

		System.out.println();

		// 测试后继算法, 除了数字没有N-1后继, 每个数字x的后继应该为x+1
		for(int i = 0 ; i < N ; i ++){
			if( i == N-1 ){
				assert bst.successor(i) == null;
				System.out.println("The successor of " + i + " is NULL");
			}
			else{
				assert bst.successor(i) == i+1;
				System.out.println("The successor of " + i + " is " + (i+1));
			}
		}
	}

}

