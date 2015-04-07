package cn.johnson.algorithm.sort;

public interface Sort {

	public <T> void sort(Comparable<T>[] array);

	public <T> void exchange(Comparable<T>[] array, int a, int b);

	public <T> boolean less(Comparable<T> a, Comparable<T> b);
}
