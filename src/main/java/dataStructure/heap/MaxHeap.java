package dataStructure.heap;

import dataStructure.array.Array;

import java.util.Random;

/**
 * 排序
 * 1：每次取出最大extraMax()或最小，然后放到一个容器里既完成。
 * 2：每次拿堆顶的，跟右边交换，交换到堆顶的做siftdown。然后在拿堆顶的重复之。空间复杂度O(1)。
 *
 */
public class MaxHeap<E extends Comparable<E>> {

	private Array<E> data;

	public MaxHeap(int capacity){
		data = new Array<>(capacity);
	}

	public MaxHeap(){
		data = new Array<>();
	}

	/**
	 * Heapify，把任意数组组成堆
	 */
	public MaxHeap(E[] arr){
		data = new Array<E>(arr);
		//找到数组里最后一个非叶子节点的节点（即最后一个父节点），然后开始逐个下浮，直到根
		for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
			siftDown(i);
	}

	// 返回堆中的元素个数
	public int size(){
		return data.getSize();
	}

	// 返回一个布尔值, 表示堆中是否为空
	public boolean isEmpty(){
		return data.isEmpty();
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
	private int parent(int index){
		if(index == 0)
			throw new IllegalArgumentException("index-0 doesn't have parent.");
		return (index - 1) / 2;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	private int leftChild(int index){
		return index * 2 + 1;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
	private int rightChild(int index){
		return index * 2 + 2;
	}

	// 向堆中添加元素到尾部
	public void add(E e){
		data.addLast(e);
		siftUp(data.getSize() - 1);
	}

	private void siftUp(int k){
		//父节点跟当前节点值作对比，父节点小则交换位置 ，继续比较
		while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
			data.swap(k, parent(k));
			//交换索引位置
			k = parent(k);
		}
	}

	// 看堆中的最大元素
	public E findMax(){
		if(data.getSize() == 0)
			throw new IllegalArgumentException("Can not findMax when heap is empty.");
		return data.get(0);
	}

	// 取出堆中最大元素
	public E extractMax(){

		E ret = findMax();
		//交换对顶和堆尾位置
		data.swap(0, data.getSize() - 1);
		data.removeLast();
		//从头开始下浮
		siftDown(0);

		return ret;
	}

	/**
	 * 跟左右孩子节点中最大的做比较，如果当前节点小，则交换。大于则不用交换了（满足二叉搜索树性质了，父亲节点大于两个孩子）
	 */
	private void siftDown(int k){
		//取k的左孩子的索引不要越界
		while(leftChild(k) < data.getSize()){
			int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
			//j+1代表右孩子，右孩子索引也不要越界
			if( j + 1 < data.getSize() &&
					//如果右孩子大于左孩子
					data.get(j + 1).compareTo(data.get(j)) > 0 )
				//则J++取右孩子。
				j ++;
			// 此时data[j] 是 leftChild 和 rightChild 中的最大值
			//如果当前节点小于最大值则交换
			if(data.get(k).compareTo(data.get(j)) >= 0 )
				break;
			data.swap(k, j);
			//交换完后索引位置继续对比下一个
			k = j;
		}
	}

	// 取出堆中的最大元素，并且替换成元素e
	public E replace(E e){
		//找到最大元素后直接替换
		E ret = findMax();
		data.set(0, e);
		//开始下浮
		siftDown(0);
		return ret;
	}


	public static void main(String[] args) {


	}


	private static void testHeap(){
		int n = 1000000;
		Random random = new Random();
		Integer[] testData = new Integer[n];
		for(int i = 0 ; i < n ; i ++)
			testData[i] = random.nextInt(Integer.MAX_VALUE);

		double time1 = testHeap(testData, false);
		System.out.println("Without heapify: " + time1 + " s");

		double time2 = testHeap(testData, true);
		System.out.println("With heapify: " + time2 + " s");
	}

	private static double testHeap(Integer[] testData, boolean isHeapify){

		long startTime = System.nanoTime();

		MaxHeap<Integer> maxHeap;
		if(isHeapify)
			maxHeap = new MaxHeap<>(testData);
		else{
			maxHeap = new MaxHeap<>();
			for(int num: testData)
				maxHeap.add(num);
		}

		int[] arr = new int[testData.length];
		for(int i = 0 ; i < testData.length ; i ++)
			arr[i] = maxHeap.extractMax();

		for(int i = 1 ; i < testData.length ; i ++)
			if(arr[i-1] < arr[i])
				throw new IllegalArgumentException("Error");
		System.out.println("Test MaxHeap completed.");

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}
}
