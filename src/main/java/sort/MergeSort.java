package sort;

import util.ArrayUtil;

/**
 * 归并排序。思想参考：https://www.jianshu.com/p/33cffa1ce613
 *
 *  时间复杂度：O(nlogn)
 *  空间复杂度：O(N)
 */
public class MergeSort implements ISort {

	@Override
	public int[] sort(int[] data) {
		int[] arr = sort(data, 0, data.length - 1);
		return arr;
	}
	private int[] sort(int[] data,int l,int r){
		if (l==r){
			return null ;
		}
		int mid = l +(r-l) /2;
		//左部分merge
		sort(data,l,mid);
		//右部分merge，并计算右边子数组此处从mid+1开始
		sort(data,mid+1,r);
		//开始合并左右两个
		int[] dest = merge(data, l, mid, r);
		return dest;
	}

	private int[] merge(int[] data,int l,int mid,int r){
		if (l==r){
			return null;
		}
		int[] tmp = new int[r-l+1];
		int i=0;
		int l1=l;
		int l2=mid+1;
		//比较左右两部分元素，哪个小哪个进入tmp。终止条件是左右两边全部走到数组重点。
		while (l1 <= mid && l2 <=r){
			tmp[i++] = data[l1] < data[l2] ?data[l1++]:data[l2++];
		}
		// 上面的循环退出后，把剩余的元素依次填入到temp中
		// 以下两个while只有一个会执行
		while (l1 <= mid){
			tmp[i++] = data[l1++];
		}
		while (l2 <= r){
			tmp[i++] = data[l2++];
		}
		// 把最终的排序的结果复制给原数组
		for (int j = 0; j < tmp.length; j++) {
			data[l+j] = tmp[j];
		}
		return data;
	}




	public static void main(String[] args) {
		ArrayUtil.orderAndPrintArr(new MergeSort());
	}


}
