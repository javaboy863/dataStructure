package lc.double_pointer;

import java.util.ArrayList;
import java.util.List;

public class lc167_TwoSum2 {
	/**
	 * 问题：有序数组[0,1,0,3,12]
	 * 对撞指针解决，设计j=0 k=length两个指针
	 * i+j=target直接返回，i+j>target则k--,反之j++。
	 * 退出条件i<j。
	 * 时间O(n)，空间O(1)
	 * 相同问题：lc 125,344,345,11
	 */
	public static List  move(int[] data,int target){
		List list = new ArrayList();
		int l =0,r=data.length-1;
		while (l<r){
			if (data[l]+data[r] == target){
				list.add(data[l]);
				list.add(data[r]);
				break;
			}else if(data[l]+data[r] >target){
				r--;
			}else if(data[l]+data[r] < target){
				l++;
			}
		}
		return list;
	}



	public static void main(String[] args) {
		int[] i ={1,2,3,5,8,11,13,15};
		System.out.println(move(i,4));

	}

}
