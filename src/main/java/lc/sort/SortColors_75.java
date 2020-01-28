//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针

package lc.sort;

import java.util.Arrays;

/**
 * 计数排序：3路快排序.可以on内搞定。因为三个颜色 正好对应三路快排的三个指针。
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
public class SortColors_75 {
	public static void main(String[] args) {
		Solution solution = new SortColors_75().new Solution();
        int[] nums ={2,0,2,1,1,0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void sortColors(int[] nums) {
			//下面两个初始值定义为-1，length是为了让这俩元素是无效数组，里面不包含任何元素
            int zero = -1;
            int two = nums.length;
            for (int i = 0; i < two;) {
                if (nums[i]==1){
                    //不操作，中间的是1
                    i++;
                }else if (nums[i]==2){
                    //等于2的话，此处不i++，因为此时把i和2指针交换了元素，而交换过的元素并不知道这个元素是什么值。所以不++
                    swap(nums,  i,--two);
                }else if (nums[i]==0){
                    swap(nums,  i,++zero);
                    i++;
                }
            }
		}

        public  void swap(int[] data,int a,int b){
            int tmp = data[a];
            data[a] = data[b];
            data[b] = tmp;
        }
	}
//leetcode submit region end(Prohibit modification and deletion)

}