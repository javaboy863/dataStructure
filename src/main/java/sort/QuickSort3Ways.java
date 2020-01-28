package sort;

import java.util.Arrays;

/**
 * 在二路排序的基础上，把等于value的元素放在另一个区间内，不参与下次的排序。
 *
 * 1.避免了二路排序解决不了的数组近乎有序的情况，先随机取出一个val，和第一个元素交换。
 * 2.定义三个指针，lt从头开始指向小于val的区域后一个元素lt = start-1，i指向目前比较的元素i= start，gt从尾开始指向大于val的第一个元素gt = end+1。保证一开始都是空集合。
 * 3.当i所指向的值小于等于val，swap（i，lt+1），lt++。当i所指向的值大于等于val，swap（i，gt-1）gt--，否则i++。直到i>=gt排序完成。将start和lt交换。
 * 4.[start,lt-1]和[gt,end]重复2.3直到start>end，排序完成。
 * @author ice
 */
public class QuickSort3Ways {
	public static void qiuckSort3(int[] array) {
		if (array.length <= 1) return;
		int start = 0;
		int end = array.length - 1;
		qiuck3(array, start, end);
	}

	private static void qiuck3(int[] array, int start, int end) {
		if (start > end) return;
//        if(end - start <=15){
		//如果数据量少就使用直接插入
//            insert(array,start,end);
//            return;
//        }

		int random = (int) (Math.random() * (end - start + 1) + start);
		swap(array, random, start);
		//找到一个随机key
		int value = array[start];
		int lt = start;
		int gt = end + 1;
		int i = start + 1;
		for (; i < gt; i++) {
			if (array[i] < value) {
				//放到小于的区域
				swap(array, lt + 1, i);
				lt++;
				i++;
			} else if (array[i] > value) {
				//放到大于区域
				swap(array, gt - 1, i);
				gt--;
			}
		}
		swap(array, lt, start);
		//直接跳过相等元素的比较
		qiuck3(array, start, lt - 1);
		qiuck3(array, gt, end);
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 测试 QuickSort3Ways
	public static void main(String[] args) {
		// 三路快速排序算法也是一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		int N = 1000000;
        int[] data = {1, 2, 3, 1, 1, 2, 3, 4, 6, 6, 1, 1, 2, 32};
        QuickSort2Ways.qiuckSort2(data);
        System.out.println(Arrays.toString(data));
		return;
	}
}