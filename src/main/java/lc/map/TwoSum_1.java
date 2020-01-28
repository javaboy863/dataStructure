//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package lc.map;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
	public static void main(String[] args) {
		Solution solution = new TwoSum_1().new Solution();
		int[] nums={3,2,4};
		int target = 6;
        int[] ints = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap();
			//这里一次遍历是因为，只要俩数相加等于target，则一定能找到。
            for (int i = 0; i < nums.length; i++) {
				int diff = target - nums[i];
                if (map.containsKey(diff)){
                    return  new int[]{map.get(diff),i};
                }
                map.put(nums[i],i);
            }
            return null;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}