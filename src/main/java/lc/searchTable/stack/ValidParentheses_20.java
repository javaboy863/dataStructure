//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: '()'
//输出: true
// 
//
// 示例 2: 
//
// 输入: '()[]{}'
//输出: true
// 
//
// 示例 3: 
//
// 输入: '(]'
//输出: false
// 
//
// 示例 4: 
//
// 输入: '([)]'
//输出: false
// 
//
// 示例 5: 
//
// 输入: '{[]}'
//输出: true 
// Related Topics 栈 字符串

package lc.searchTable.stack;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 思路：通过栈，加入是前括号的符号，然后下一个如果不是前括号的一个，则跟取出来的对比。
 */
public class ValidParentheses_20 {
	public static void main(String[] args) {
		Solution solution = new ValidParentheses_20().new Solution();
//        String s = "([])";
        String s = "(]";
        System.out.println(solution.isValid(s));

    }

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isValid(String s) {
            Stack<Character> stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (c == '(' || c == '{' ||c == '[' ){
                    stack.push(c);
                }else {
                    if (stack.isEmpty()){
                        return false;
                    }
                    Character popChar = stack.pop();
                    if (c == '}' && popChar != '{') {
                        return false;
                    }else if (c == ')' && popChar != '('){
                        return false;
                    }else if (c == ']' && popChar != '['){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
		}
	}

	/*
	最优解，通过数组模拟栈
	public boolean isValid(String s) {
		int top = 1;
		char[] stack = new char[s.length()+1];
		for (char c:s.toCharArray()){
			if(c == '{' || c == '[' || c == '(' ){
				stack[top++] = c;
			}else if(c == '}' && stack[--top] != '{'){
				return false;
			}
			else if(c == ']' && stack[--top] != '['){
				return false;
			}
			else if(c == ')' && stack[--top] != '('){
				return false;
			}
		}
		return top == 1;
	}*/

//leetcode submit region end(Prohibit modification and deletion)

}