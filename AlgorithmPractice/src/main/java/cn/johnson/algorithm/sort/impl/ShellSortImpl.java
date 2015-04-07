package cn.johnson.algorithm.sort.impl;

import cn.johnson.algorithm.sort.Sort;

public class ShellSortImpl implements Sort {

	@Override
	public <T> void sort(Comparable<T>[] array) {
		int N = array.length;
		int h = 1;

		while (h < N / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		}

		while (h >= 1) { // h-sort the array.
			for (int i = h; i < N; i++) { // Insert a[i] among a[i-h],
											// a[i-2*h],a[i-3*h]... .
				for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
					exchange(array, j, j - h);
				}
			}

			h = h / 3;
		}
	}

	@Override
	public <T> void exchange(Comparable<T>[] array, int a, int b) {
		Comparable<T> temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	@Override
	public <T> boolean less(Comparable<T> a, Comparable<T> b) {
		return a.compareTo((T) b) < 0;
	}

}
