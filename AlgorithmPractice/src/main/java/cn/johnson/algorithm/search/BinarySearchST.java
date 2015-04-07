package cn.johnson.algorithm.search;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int size;

	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	public int size() {
		return size;
	}

	public Value get(Key key) {
		if (!isEmpty()) {
			return null;
		}
		int i = rank(key);
		if (i < size && keys[i].compareTo(key) == 0) {
			return values[i];
		} else {
			return null;
		}

	}

	public int rank(Key key) {

		return rank(key, 0, size - 1);
	}

	private int rank(Key key, int lo, int hi) {

		// 当往前搜索时lo是当前最小下标也是要搜索值的rank 当往后搜索时则应该比当前最大值大 所以也是lo
		if (hi < lo) {
			return lo;
		}

		int mid = lo + ((hi - lo) >>> 1);

		if (keys[mid].compareTo(key) < 0) {
			return rank(key, mid + 1, hi);
		} else if (keys[mid].compareTo(key) > 0) {
			return rank(key, lo, mid - 1);
		} else {
			return mid;
		}

	}

	public void put(Key key, Value value) {

		int i = rank(key);

		// according to the binary search i should be less than or equal to
		// size;
		if (i < size && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}

		for (int j = size; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}

		keys[i] = key;
		values[i] = value;
		size++;
	}

	public void delete(Key key) {

	}

	public boolean isEmpty() {
		return size == 0;
	}
}
