package cn.johnson.algorithm.sort.impl;

public class MaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int n = 0;

	public MaxPQ() {
	}

	public MaxPQ(int max) {
		pq = (Key[]) new Comparable[max + 1];
	}

	public MaxPQ(Key[] a) {

	}

	public void insert(Key v) {
		pq[++n] = v;
		swim(n);
	}

	public Key max() {
		return pq[1];
	}

	public Key delMax() {
		Key max = pq[1]; // Retrieve max key from top.
		exch(1, n--); // Exchange with last item.
		pq[n + 1] = null; // Avoid loitering.
		sink(1); // Restore heap property.
		return max;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= n) {

			int j = 2 * k;

			// compare with the bigger one of it's child
			if (j < n && less(j, j + 1)) {
				j++;
			}

			if (!less(k, j)) {
				break;
			}

			exch(k, j);

			k = j;
		}
	}

	public static void main(String[] args) {
		MaxPQ<Integer> pq = new MaxPQ<Integer>(4);
		pq.insert(8);
		pq.insert(2);
		pq.insert(4);
		pq.insert(7);
		while (!pq.isEmpty()) {
			System.out.println(pq.delMax());
		}
	}

}
