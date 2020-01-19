package sort;

import util.ArrayUtil;

/**
 * 每次遍历找出最小的元素，放最左边。需要遍历N*N次
 * O(N^2)
 */
public class SelectionSort implements ISort {

	@Override
	public Comparable[] sort(Comparable[] data) {
		ArrayUtil.assertEmpty(data);
		int length = data.length;
		for (int i = 0; i < length; i++) {
			for (int j = i+1; j < length; j++) {
				// 寻找[i, n)区间里的最小值的索引
				//重点：第二个数跟第一个做对比，比第一个小的话就交换位置，这样一次遍历一次找出一个最小的
				if (data[j].compareTo(data[i]) < 0 ){
					ArrayUtil.swap(data,j,i);
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		ArrayUtil.orderAndPrintArr(new SelectionSort());
	}


}
