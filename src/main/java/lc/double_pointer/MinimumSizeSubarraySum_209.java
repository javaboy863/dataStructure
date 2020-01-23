//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。 
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找

package lc.double_pointer;

/**
 * 时间O(N)
 * 空间O(1)
 */
public class MinimumSizeSubarraySum_209 {
	public static void main(String[] args) {
		Solution solution = new MinimumSizeSubarraySum_209().new Solution();
		int s = 7;
		int[] nums = {2,3,1,2,4,3};
		System.out.println(solution.minSubArrayLen(s, nums));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int minSubArrayLen(int s, int[] nums) {
			//[l...r]滑动窗口两个指针，r=-1标识不包含任何元素，如果为0则包含了元素
			int l=0,r=-1;
			int sum = 0;
			//存放结果，初始值为最大值+1.
			int res = nums.length+1;
			//边界，只要左滑动窗口指针小于数组长度
			while (l < nums.length){
				//边界
				if (r+1 <nums.length && sum <s){
					//小于则r先++放到nums
					sum += nums[++r];
				}else {
					//l指针往前，然后在++
					sum -= nums[l++];
				}
				//一旦找到了就保存一下。
				if (sum >= s){
					//取滑动窗口里与res里小的
					res = Math.min(r-l+1,res);
				}
			}
			//带表res没有动，没有解的情况
			if (res == nums.length+1){
				return 0;
			}
			return  res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}