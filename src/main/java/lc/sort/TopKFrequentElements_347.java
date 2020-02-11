//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 说明： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 
// Related Topics 堆 哈希表

package lc.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 桶排序
 * O(n)
 */
public class TopKFrequentElements_347 {
	public static void main(String[] args) {
		Solution solution = new TopKFrequentElements_347().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<Integer> topKFrequent(int[] nums, int k) {
			//step1—用哈希表统计数组中各元素出现的频次，表中“键”为元素数值，“值”为对应元素出现的频次
			Map<Integer,Integer> map=new HashMap<Integer,Integer>();
			for(int num:nums)
			{
				map.put(num, map.getOrDefault(num, 0) + 1);
			}

			//step2—桶排序
			List<Integer>[] bucket=new List[nums.length+1];//定义足够数量的桶
			for(int key:map.keySet())//按“键”遍历
			{
				int count=map.get(key);//获取数值为key的元素出现的频次
				//把出现频次相同的元素“扔”到序号等于频次的桶中
				if(bucket[count]==null)
					bucket[count]=new ArrayList<Integer>();
				bucket[count].add(key);
			}
			//step3—“逆序”取数据
			List<Integer> result=new ArrayList<Integer>();
			for(int i=nums.length;i>0;i--)//注意i的起始值，当数组只有一个数据时
			{
				if(bucket[i]!=null&&result.size()<k)
					result.addAll(bucket[i]);
			}
			return result;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}