package cn.johnson.algorithm.collections.impl;

import cn.johnson.algorithm.collections.UnionFind;

public class WeightedQuickUnionImpl implements UnionFind {

	private int[] id;

	private int count;

	private int[] size;

	public WeightedQuickUnionImpl(int n) {

		id = new int[n];

		size = new int[n];

		count = n;

		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);

		int qRoot = find(q);

		if (pRoot == qRoot) {
			return;
		}

		// make smaller root point to larger one
		if (size[pRoot] < size[qRoot]) {

			id[pRoot] = qRoot;

			size[qRoot] += size[pRoot];
		} else {

			size[pRoot] += size[qRoot];

			id[qRoot] = pRoot;
		}

		count--;

	}

	@Override
	public int find(int p) {

		// follow links to find a root
		while (p != id[p]) {
			p = id[p];
		}

		return p;
	}

	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public int count() {
		return count;
	}

}
