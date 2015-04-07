package cn.johnson.algorithm.sort.impl;

import cn.johnson.algorithm.sort.Sort;

public class SelectSortImpl implements Sort {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void sort(Comparable[] array) {

		int minIndex = 0;
		for (int i = 0; i < array.length; i++) {

			minIndex = i;

			for (int j = i + 1; j < array.length; j++) {

				if (less(array[j], minIndex)) {

					minIndex = j;

				}

			}

			exchange(array, i, minIndex);
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
