//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计

package lc.design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 嵌套的list，要求给出其迭代器的next()和hasNext函数。可以使用一个stack来维护当前list剩余元素。
 * 将list反向添加进stack中，这样就可以让先出现的数先被stack弹出。
 */
public class FlattenNestedListIterator_341 {
	public static void main(String[] args) {
//        FlattenNestedListIterator solution = new FlattenNestedListIterator().new NestedIterator();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 * <p>
	 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 * public boolean isInteger();
	 * <p>
	 * // @return the single integer that this NestedInteger holds, if it holds a single integer
	 * // Return null if this NestedInteger holds a nested list
	 * public Integer getInteger();
	 * <p>
	 * // @return the nested list that this NestedInteger holds, if it holds a nested list
	 * // Return null if this NestedInteger holds a single integer
	 * public List<NestedInteger> getList();
	 * }
	 */
	public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack;
        ////对每一个list都反转
		public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size()-1; i >= 0 ; i--) {
                stack.push(nestedList.get(i));
            }
		}

		@Override
		public Integer next() {
            return stack.pop().getInteger();
		}

		@Override
		public boolean hasNext() {
		    while (!stack.isEmpty()){
                NestedInteger nestedInteger = stack.peek();
                if (nestedInteger.isInteger()){
                    return true;
                }else {
                    //将list反向添加进stack中，这样就可以让先出现的数先被stack弹出。
                    stack.pop();
                    for (int i = nestedInteger.getList().size()-1; i >= 0 ; i--) {
                        stack.push(nestedInteger.getList().get(i));
                    }
                }
            }
		    return false;
		}
	}

	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
//leetcode submit region end(Prohibit modification and deletion)
	private interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}