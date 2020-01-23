package sort;

import util.ArrayUtil;

/**
 * 找出一个元素X，使得整个元素X左边都是小于x，右边都是大于x的
 *
 */
public class QuicSort implements ISort {

	@Override
	public Comparable[] sort(Comparable[] data) {
		ArrayUtil.assertEmpty(data);
		Comparable[] sortedData = sort(data, 0, data.length-1);
		return sortedData;
	}

	private Comparable[] sort(Comparable[] data,int l,int r) {
		//左边索引右边重合代表本趟排序结束
		if (l >= r){
			return null;
		}
		//找出这次的基准索引坐标
		int p = partition(data,l,r);
		//递归索引左边和索引右边的队列
		sort(data,l,p-1);
		sort(data,p+1,r);
		return data;
	}
	 /**
	  * 对arr[l...r]这部分进行parttion操作
	  *  返回p，使得arr[l....p-1] < arr[p] ;arr[p+1....r] > arr[p]
	  *  这里的j是小于V区间的索引尾部，i是代表对比的下一个数组里的元素。l代表元素左边
	  */
	private int partition(Comparable[] data,int l,int r) {
//		ArrayUtil.swap( arr, l , (int)(Math.random()*(r-l+1))+l );

		//本次的基准索引坐标，本次用左边第一个作为基准点
		Comparable v = data[l];
		//是小于V区间的索引尾部,j+1到i-1都是大于元素V的。
		int j = l ;
		for (int i = l+1; i <= r; i++) {
			// >v 的情况直接i++跳过，对比当前i后面的元素
			if (data[i].compareTo(v) < 0){
				//注意此处把j+1和i交换
				ArrayUtil.swap(data,j+1,i);
				j++;
			}
		}
		//最后把基准l和J交换。
		ArrayUtil.swap(data,l,j);
		return j;
	}

	public static void main(String[] args) {
		ArrayUtil.orderAndPrintArr(new QuicSort());
	}


}
