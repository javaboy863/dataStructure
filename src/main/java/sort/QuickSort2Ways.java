package sort;

import java.util.Arrays;

/**
 * 当数组中存在大量重复元素，无论是小于等于交换，还是小于交换，都会导致一边区域数据远大于另一半，当重复量很大时近似于一个O（n^2）的排序。
 *
 * 1.避免数组近乎有序，先随机取出一个val，和第一个元素交换。
 * 2.定义两个指针，i从头开始指向小于val的区域后一个元素，j从尾开始指向大于val的第一个元素。
 * 3.当i所指向的值小于等于val，i++，否则暂停。当j所指向的值大于等于val，j--，否则暂停。当i和j都暂停时，交换i和j所指位置的元素。直到i>j结束，让start赋给j所指向的位置，返回j。
 * 4.重复2.3直到start>end，排序完成。
 */
public class QuickSort2Ways {


	public static int[] qiuckSort2(int[] array) {
		if (array.length <= 1) return array;
		qiuck2(array, 0, array.length - 1);
		return array;
	}

	private static void qiuck2(int[] array, int start, int end) {
		if (start > end) return;
		int key = selectionKey2(array, start, end);
		qiuck2(array, start, key - 1);
		qiuck2(array, key + 1, end);
	}

	private static int selectionKey2(int[] array, int start, int end) {
		int random = (int) (Math.random() * (end - start + 1) + start);
		swap(array, random, start);
        //当数组中元素基本上有序，每次取得第一个元素都是最大或最小值，会导致元素左右个数分布不不均匀，当完全有序时近似于一个O（n^2）的排序。
        //解决：随机选取val值，在与第一个元素交换，让递归顺利进行。
		int value = array[start];
		//从头开始往后[start+1,i-1]
		int i = start + 1;
		//从尾开始往前[j+1,end]
		int j = end;
		while (true) {
			//相当于把等于key的值均分到两边
			while (i <= end && array[i] < value) i++;
			while (j >= start + 1 && array[j] > value) j--;
			//交换后两个指针都移动一步
			if (i > j) break;
			swap(array, i, j);
			i++;
			j--;
		}
		swap(array, start, j);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 测试 QuickSort
	public static void main(String[] args) {

		//双路快速排序算法也是一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		int N = 1000000;
//        ArrayUtil.orderAndPrintArr(new QuickSort2Ways());
//        Comparable[] data = ArrayUtil.getData(150);
		int[] data = {1, 2, 3, 1, 1, 2, 3, 4, 6, 6, 1, 1, 2, 32};
		QuickSort2Ways.qiuckSort2(data);
		System.out.println(Arrays.toString(data));
	}
}