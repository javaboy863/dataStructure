//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package lc.double_pointer.slideWindow;

/**
 * 时间复杂度0（N）
 */
public class LongestSubstringWithoutRepeatingCharacters_438 {
	public static void main(String[] args) {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters_438().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lengthOfLongestSubstring(String s) {
		    //int 默认是0
            int[] freq = new int[256];

            int l = 0, r = -1; //滑动窗口为s[l...r]
            int res = 0;

            // 整个循环从 l == 0; r == -1 这个空窗口开始
            // 到l == s.size(); r == s.size()-1 这个空窗口截止
            // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
            while(l < s.length()){

                if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0)
                    freq[s.charAt(++r)] ++;
                else    //r已经到头 || freq[s[r+1]] == 1
                    freq[s.charAt(l++)] --;
                //数组从0开始所以要+1
                res = Math.max(res, r-l+1);
            }

            return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}