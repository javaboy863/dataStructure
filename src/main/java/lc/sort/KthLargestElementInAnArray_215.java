//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法

package lc.sort;

/**
 * 1、可堆排序，构建个K个元素的小顶堆，只要堆元素大于K个就移出堆顶小的元素。
 * 2、排序后直接取对应位置上的元素
 * 3、快排改进，先任取一个数，把比它大的数移动到它的左边，比它小的数移动到它的右边。
 * 移动完成一轮后，看该数的下标（从0计数），如果刚好为k-1则它就是第k大的数，
 * 如果小于k-1，说明第k大的数在它右边，如果大于k-1则说明第k大的数在它左边，
 * 取左边或者右边继续进行移动，直到找到。
 */
public class KthLargestElementInAnArray_215 {
	public static void main(String[] args) {
		Solution solution = new KthLargestElementInAnArray_215().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int findKthLargest(int[] nums, int k) {
			int len=nums.length;
			int left=0,right=len-1;
			int target=len-k;                                //第k大的元素的数组下标就是len-k，可通过找规律得出
			while (true){
				int index=partition(nums,left,right);       //index用来判断nums[left]排在数组中的第几位大小，并将其移到对应的位置
				if(index==target)
					return nums[target];
				if(index>target)                         //因为nums[left]比第k大的数大，nums[left]左边的数都比它小，所以使right=index-1.继续接下来的判断
					right=index-1;
				if(index<target)
					left=index+1;
			}
		}

		public int partition(int[] nums, int left, int right) {
			int pivot=nums[left];
			int j=left;                                   //j用来判断pivot排在数组中的第几个大小位置
			for(int i=left+1;i<=right;i++){
				if(nums[i]<pivot){
					j++;
					swap(nums,j,i);
				}
			}
			swap(nums,j,left);
			return j;
		}

		private void swap(int[] nums, int index1, int index2) {
			if(index1==index2) return ;
			int temp=nums[index1];
			nums[index1]=nums[index2];
			nums[index2]=temp;
		}

	}

//leetcode submit region end(Prohibit modification and deletion)

}