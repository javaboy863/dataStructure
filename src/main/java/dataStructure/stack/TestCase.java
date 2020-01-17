package dataStructure.stack;

import java.util.Random;

public class TestCase {


	// 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
	private static double testStack(Stack<Integer> stack, int opCount){

		long startTime = System.nanoTime();

		Random random = new Random();
		for(int i = 0 ; i < opCount ; i ++)
			stack.push(random.nextInt(Integer.MAX_VALUE));
		for(int i = 0 ; i < opCount ; i ++)
			stack.pop();

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

	public static void main(String[] args) {

		int opCount = 1000000;

		ArrayStack<Integer> arrayStack = new ArrayStack<>();
		double time1 = testStack(arrayStack, opCount);
		System.out.println("ArrayStack, time: " + time1 + " s");

		ListNodeStack<Integer> linkedListStack = new ListNodeStack<>();
		double time2 = testStack(linkedListStack, opCount);
		System.out.println("LinkedListStack, time: " + time2 + " s");

		// 其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作
	}
}
