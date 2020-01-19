package lc.three_pointer;

import util.ArrayUtil;

import java.util.Arrays;

public class lc75_SortColor {
	/**
	 * 问题：0-2，三个数的数组，做排序。
	 * 计数排序：3路快排序
	 * 一个zero指针【0...zero】
	 * 一个two指针[two...n-1]
	 * i指针负责索引遍历，负责1的部分【zero+1....i-1】
	 * i发现是1则++
	 * 发现是2则把i和two--交换位置，two--，i++
	 * 发现是1则把zero+1和i交换位置。zero++，i++
	 * 时间O(n) 空间O(1)
	 *
	 * lc 88，215
	 */
	static Integer[] sort(Integer[] data){
		int zero = -1;
		int two = data.length;
		for (int i = 0; i < two;) {
			if (data[i]==1){
				//不操作，中间的是1
				i++;
			}else if (data[i]==2){
				//等于2的话，此处不i++，因为此时把i和2指针交换了元素，而交换过的元素并不知道这个元素是什么值。所以不++
				ArrayUtil.swap(data,  i,--two);
			}else if (data[i]==0){
				ArrayUtil.swap(data,  i,++zero);
				i++;
			}

		}
		return data;
	}

	public static void main(String[] args) {
		Integer[] i ={1,0,2,0,2,1,0,2,2};
		System.out.println(Arrays.toString(sort(i)));
	}
}
