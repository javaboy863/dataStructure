package sort;

import util.ArrayUtil;

/**
 * j和j+1比较，大就交换，继续j+1和j+2比较。如此。
 */
public class BubbleSort implements ISort {

	@Override
	public int[] sort(int[] data) {
		ArrayUtil.assertEmpty(data);
		int length = data.length;
		for (int i = 0; i < length; i++) {
			//第二次的终止条件是n-1,否则会溢出
			for (int j = 0; j < length -1; j++) {
				if (data[j] > data[j+1]){
					ArrayUtil.swap(data,j,j+1);
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		ArrayUtil.orderAndPrintArr(new BubbleSort());
	}


}
