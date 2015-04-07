package cn.johnson.algorithm.sort.impl;

import java.util.Arrays;

import cn.johnson.algorithm.sort.Sort;
import cn.johnson.algorithm.stdlib.StdRandom;

public class QuickSortImpl implements Sort {

	@Override
	public void sort(Comparable[] array) {
		StdRandom.shuffle(array);
		sort(array, 0, array.length - 1);
	}

	private void sort(Comparable[] array, int lo, int hi) {

		if (hi <= lo) {
			return;
		}
		int j = partition(array, lo, hi); // Partition (see page 291).
		sort(array, lo, j - 1); // Sort left part a[lo .. j-1].
		sort(array, j + 1, hi);
	}

	private int partition(Comparable[] array, int lo, int hi) {
		int i = lo, j = hi + 1; // left and right scan indices
		Comparable v = array[lo]; // partitioning item

		while (true) { // Scan right, scan left, check for scan complete, and
						// exchange.
			while (less(array[++i], v)) {

				if (i == hi) {
					break;
				}
			}

			while (less(v, array[--j])) {

				if (j == lo) {
					break;
				}
			}

			if (i >= j) {
				break;
			}

			exchange(array, i, j);
		}

		exchange(array, lo, j); // Put v = a[j] into position

		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	@Override
	public void exchange(Comparable[] array, int a, int b) {
		Comparable temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	@Override
	public boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static void main(String[] args) {
		Integer[] arr = { 9, 2, 1, 5, 2, 1, 36, 11, 21, 4 };

		new QuickSortImpl().sort(arr);

		System.out.println(Arrays.toString(arr));
	}

}
