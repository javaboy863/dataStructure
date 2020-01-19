package lc.double_pointer;

import util.ArrayUtil;

import java.util.Arrays;

public class lc283_movezero {
	/**
	 * [0,1,0,3,12] ，双指针，第一个指针指向0,用于保存非0元素。第二个指针指不断遍历，
	 * 发现非0元素后就和K指向的位置交换元素，然后K索引++。
	 * 时间O(1) 空间(O1)
	 *  lc 27,26,80 待解决
	 */
	public static Integer[]  move(Integer[] data){

		int k =0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] != 0 ){
				ArrayUtil.swap(data, i, k++);
			}
		}
		return data;
	}



	public static void main(String[] args) {
		Integer[] i ={1,0,2,0,12,0,5,9,2};
		System.out.println(Arrays.toString(move(i)));

	}

}
