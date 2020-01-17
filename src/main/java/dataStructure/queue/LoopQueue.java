package dataStructure.queue;


/**
 * 循环队列，解决了普通数组出队的时候所有元素往左边挪动的情况。
 * front记录队首，tail记录队尾记录下一次入队元素的位置。当删除一个元素的时候，
 * 只要维护front的指针指向++即可（不适用任意位置删除，只能队列这种场景。）。所以不需要挪动。
 * tail+1=front代表队列满了，因为是个环所以是(tail+1)%size == front 队列满
 * front或tail+1%size 当跟size大小一样的时候取余会从0开始，等于环中的开始位置。
 */
public class LoopQueue<E> implements Queue<E> {

	private int size;
	/**
	 * 指向队首有元素的元素
	 */
	private int front;
	/**
	 * 指向队尾的待添加的元素，-1等于已有的元素
	 */
	private int tail;

	private E[] data;


	@Override
	public void enqueue(E o) {
		//tail的位置
		if ((tail+1) % data.length ==front){
			//resize
			resize(getCapacity() * 2);
		}
		data[tail] = o;
		tail =(tail+1) % data.length;
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()){
			throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		}
		E ret = data[this.front];
		data[this.front] = null;
		//因为有环，所以这样取下一个
		this.front = (this.front +1) % data.length;
		size--;
		if (size == getCapacity() / 4 && getCapacity() / 2 != 0 ){
			resize(getCapacity()*2);
		}
		return ret;
	}

	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity+1];
		for (int i = 0; i < size; i++) {
			//这样取环中数据，front由于是固定的，跟i相加后在跟data.length取余，
			// 最后当data[size]==data.length的时候，取余为0，等于是开始循环了。
			newData[i] = data[(i+this.front ) % data.length];
		}
		data = newData;
		//由于扩容，重置front为0
		front = 0;
		tail = size;

	}


	/**重要的方法分割线，上面都是重要的方法。 **/

	public LoopQueue(int capacity){
		data = (E[])new Object[capacity+1];
		//初始都是0
		front=0;
		tail=0;
		size=0;
	}

	public LoopQueue(){
		this(10);
	}

	public int getCapacity() {
		return data.length-1;
	}

	@Override
	public int getSize() {
		return size;
	}

	/**
	 * 首尾指针一致代表队列空
	 */
	@Override
	public boolean isEmpty() {
		return front == tail;
	}


		@Override
	public E getFront() {
		if (isEmpty()){
			throw new IllegalArgumentException("empty queue");
		}
		//返回front指针指向
		return data[front];
	}

	@Override
	public String toString(){

		StringBuilder res = new StringBuilder();
		res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
		res.append("front [");
		for(int i = front ; i != tail ; i = (i + 1) % data.length){
			res.append(data[i]);
			if((i + 1) % data.length != tail)
				res.append(", ");
		}
		res.append("] tail");
		return res.toString();
	}

	public static void main(String[] args){

		LoopQueue<Integer> queue = new LoopQueue<>(5);
		for(int i = 0 ; i < 10 ; i ++){
			queue.enqueue(i);
			System.out.println(queue);

			if(i % 3 == 2){
				queue.dequeue();
				System.out.println(queue);
			}
		}
	}
}
