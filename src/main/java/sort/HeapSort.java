package sort;

import util.ArrayUtil;

/**
 *
 *
 */
public class HeapSort implements ISort {

	@Override
	public int[] sort(int[] data) {
		ArrayUtil.assertEmpty(data);
		return data;
	}

	public static void main(String[] args) {
		ArrayUtil.orderAndPrintArr(new HeapSort());
	}


}
