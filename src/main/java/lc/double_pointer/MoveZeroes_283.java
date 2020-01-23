//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针

package lc.double_pointer;
/**
 * [0,1,0,3,12] ，双指针，第一个指针指向0,用于保存非0元素。第二个指针指不断遍历，
 * 发现非0元素后就和K指向的位置交换元素，然后K索引++。
 * 时间O(1) 空间(O1)
 *  lc 27,26,80 待解决
 */
public class MoveZeroes_283 {
	public static void main(String[] args) {
		Solution solution = new MoveZeroes_283().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void moveZeroes(int[] nums) {
			int k =0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0 ){
					swap(nums, i, k++);
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