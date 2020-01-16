package searh;

import util.ArrayUtil;

public class SequentialSearch implements ISearch{

	@Override
	public int search(int[] data, int target) {
		ArrayUtil.assertEmpty(data);
		for (int i = 0; i < data.length ; i++) {
			if (data[i] == target){
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		ArrayUtil.searchAndPrintArr(new SequentialSearch(),2);

	}
}
