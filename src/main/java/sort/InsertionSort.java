package sort;

import util.ArrayUtil;

/**
 * 每次遍历找出最小的元素，放最左边。需要遍历N*N次
 * O(N^2)
 */
public class InsertionSort implements ISort {

	@Override
	public int[] sort(int[] data) {
		ArrayUtil.assertEmpty(data);
		int length = data.length;
		//第1个元素可以不考虑，从2开始，所以索引从1开始
		for (int i = 1; i < length; i++) {
			//每次拿I和I前面一个元素比较。j>0最多循环到索引1的位置
			for (int j = i; j >0; j--) {
				//拿J和J-1作对比，只要小于就交换，否则只要有一个大于就break结束
				if (data[j] < data[j-1]){
					ArrayUtil.swap(data,j,j-1);
				}else {
					break;
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		ArrayUtil.orderAndPrintArr(new InsertionSort());
	}


}
