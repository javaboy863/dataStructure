package util;

import searh.BinarySearch;
import searh.ISearch;
import sort.BubbleSort;
import sort.ISort;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

	public static void swap(int[] data,int a,int b){
		int tmp = data[a];
		data[a] = data[b];
		data[b] = tmp;
	}

	public static void assertEmpty(int[] data){
		if (data.length ==0){
			throw new IllegalArgumentException("data empty...");
		}
	}


	public static int[] getData(int size){
		Random random = new Random();
		int[] data = new int[size];
		for (int i = 0; i < size; i++) {
			int result = random.nextInt(100);
			data[i] = result;
		}
		return data;
	}

	public static void orderAndPrintArr(ISort sort){
		int[] data = ArrayUtil.getData(15);
		System.out.println("before------------------------------");
		System.out.println(Arrays.toString(data));
		int[] sortedArr = sort.sort(data);
		System.out.println("after------------------------------");
		System.out.println(Arrays.toString(sortedArr));
	}

	private static  int[] searchArr = {0,22,88,11,21,88,2,28,72,73,99};
	public static void searchAndPrintArr(ISearch search,int target){
		if (search instanceof BinarySearch){
			searchArr = new BubbleSort().sort(searchArr);
		}
		System.out.println("arr------------------------------");
		System.out.println(Arrays.toString(searchArr));
		int index = search.search(searchArr,target);
		System.out.println("index------------------------------");
		System.out.println(index);
	}


}
