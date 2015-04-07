package cn.johnson.algorithm.sort.impl;

import cn.johnson.algorithm.sort.Sort;

public class InsertionSortImpl implements Sort {

	@Override
	public void sort(Comparable[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length && j > 0; j--) {
				if (less(array[j], array[j - 1])) {
					exchange(array, j, j - 1);
				}
			}
		}

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

}
