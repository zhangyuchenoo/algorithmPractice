package cn.johnson.algorithm.sort.impl;

import java.util.Arrays;

import cn.johnson.algorithm.sort.Sort;

public class MergeSortImpl implements Sort {

	private Comparable[] temp;

	@Override
	public <T> void sort(Comparable<T>[] array) {
		temp = new Comparable[array.length];
		sort(array, 0, array.length - 1);
	}

	@Override
	public <T> void exchange(Comparable<T>[] array, int a, int b) {
		// TODO
	}

	@Override
	public <T> boolean less(Comparable<T> a, Comparable<T> b) {
		return a.compareTo((T) b) < 0;
	}

	private <T> void merge(Comparable<T>[] array, int lo, int mid, int hi) {

		for (int i = lo; i <= hi; i++) {
			temp[i] = array[i];
		}

		for (int k = lo, i = lo, j = mid + 1; k <= hi; k++) {

			if (i > mid) {
				array[k] = temp[i++];
			} else if (j > hi) {
				array[k] = temp[i++];
			} else if (less(temp[i], temp[j])) {
				array[k] = temp[i++];
			} else {
				array[k] = temp[j++];
			}
		}
	}

	private <T> void sort(Comparable<T>[] array, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int mid = lo + ((hi - lo) >> 2);

		sort(array, lo, mid);
		sort(array, mid + 1, hi);
		merge(array, lo, mid, hi);
	}

	public static void main(String[] args) {
		Integer[] arr = { 8, 3, 1, 2 };

		new MergeSortImpl().sort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
