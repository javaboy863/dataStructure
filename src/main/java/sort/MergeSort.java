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
	public Comparable[] sort(Comparable[] data) {
		Comparable[] arr = sort(data, 0, data.length - 1);
		return arr;
	}
	private Comparable[] sort(Comparable[] data,int l,int r){
		if (l==r){
			return null ;
		}
		//取中间
		int mid = (l+r)/2;
		//左部分merge
		sort(data,l,mid);
		//右部分merge，并计算右边子数组此处从mid+1开始
		sort(data,mid+1,r);
		//开始合并左右两个
		Comparable[] dest = merge(data, l, mid, r);
		return dest;
	}

	private Comparable[] merge(Comparable[] data,int l,int mid,int r){
		if (l==r){
			return null;
		}
		//这里因为tmp是从0开始的，所以要r-l后+1
		Comparable[] tmp = new Comparable[r-l+1];
		int i=0;
		int l1=l;
		int l2=mid+1;
		//比较左右两部分元素，哪个小哪个进入tmp。终止条件是左右两边全部走到数组终点。
		while (l1 <= mid && l2 <=r){
			tmp[i++] = data[l1].compareTo(data[l2]) < 0 ?data[l1++]:data[l2++];
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



	// Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
	// 可以在1秒之内轻松处理100万数量级的数据
	// 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
	// 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
	public static void main(String[] args) {
		ArrayUtil.orderAndPrintArr(new MergeSort());
	}


}
