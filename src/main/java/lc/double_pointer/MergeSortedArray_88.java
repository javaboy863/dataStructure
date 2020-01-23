//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package lc.double_pointer;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 *  把nums2合并到nums1中，并保持有序
 *  定义三个指针，index1,index2,index3
 *  只要1和2指针>0，从队尾取开始比较两个数组，更大的放index3位置。
 *  最后如果index2不等于0则顺序从队尾开始放到index3.
 */
public class MergeSortedArray_88 {
	public static void main(String[] args) {
		Solution solution = new MergeSortedArray_88().new Solution();
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int[] nums2 = {2, 5, 6};
//        int[] nums1 = {0};
//        int[] nums2 = {1};
		solution.merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
		    //定义三个指针，题目保证了nums1>=m+n
			int index1 = m-1, index2 = n-1, index3 = m + n-1;
			while (index1 >= 0 && index2 >= 0) {
				if (nums1[index1] > nums2[index2]) {
				    //队尾是俩数组中大的
					nums1[index3--] = nums1[index1--];
				} else {
					nums1[index3--] = nums2[index2--];
				}
			}
			//如果队列2 还没处理完，因为是有序的，直接把剩下的从队尾放到数组1的队尾
            while (index2 >= 0) {
                nums1[index3--] = nums2[index2--];
            }
        }


	}
//leetcode submit region end(Prohibit modification and deletion)

}