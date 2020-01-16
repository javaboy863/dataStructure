package searh;

import util.ArrayUtil;

/**
 * 前提是有序
 */
public class BinarySearch implements ISearch {
	@Override
	public int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < target) {
				low = mid + 1;
			}
			if (nums[mid] > target) {
				high = mid - 1;
			}
			if (nums[mid] == target) {
				return mid;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		ArrayUtil.searchAndPrintArr(new BinarySearch(), 99);
	}

}
