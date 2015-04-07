package cn.johnson.algorithm.collections.impl;

import cn.johnson.algorithm.collections.UnionFind;

public class UnionFindQuickUnionImpl implements UnionFind {

	private int id[];

	private int count;

	public UnionFindQuickUnionImpl(int n) {

		id = new int[n];

		count = n;

		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {

		int pRoot = find(p);

		int qRoot = find(q);

		if (pRoot == qRoot) {
			return;
		}

		id[pRoot] = qRoot;

		count--;
	}

	@Override
	public int find(int p) {
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
