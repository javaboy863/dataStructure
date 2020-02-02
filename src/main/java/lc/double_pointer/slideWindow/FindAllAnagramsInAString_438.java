//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表

package lc.double_pointer.slideWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口解决 +hashtable
 * 0（N）
 */
public class FindAllAnagramsInAString_438 {
	public static void main(String[] args) {
		String s1 = "abab";
		String p1 = "ab";
		Solution solution = new FindAllAnagramsInAString_438().new Solution();
		System.out.println(solution.findAnagrams(s1,p1));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			//用数组来创建两个哈希表；
			int[] vp = new int[26];
			//vs用来存储s中的每一位字符，每次跟跟vp做对比
			int[] vs = new int[26];
			char []cs = s.toCharArray();
			char []ps = p.toCharArray();

			List<Integer> result = new ArrayList<>();
			//遍历p字符串数组；结果存入到vp中；存入的是数字,这里减-a是做个偏移
			for (char c : ps) {
				vp[c-'a']++ ;
			}

			for (int i = 0; i < cs.length; i++) {
				//如果说此时的下标大于滑动窗口的长度；要把尾部的减去
				if ( i >= p.length()){
					vs[cs[i-ps.length]-'a']--;
				}
				//将当前的字符加入到滑动窗口中；
				vs[cs[i]-'a']++;
				if (Arrays.equals(vs,vp)){
					//一致的话返回坐标记得+1
					result.add(i+1-p.length());
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}