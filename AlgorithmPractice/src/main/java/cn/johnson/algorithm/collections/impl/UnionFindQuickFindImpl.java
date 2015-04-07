package cn.johnson.algorithm.collections.impl;

import cn.johnson.algorithm.collections.UnionFind;

public class UnionFindQuickFindImpl implements UnionFind {

	private int[] id;

	private int count;

	public UnionFindQuickFindImpl(int n) {

		id = new int[n];

		count = n;

		for (int i = 0; i < n; i++) {
			id[i] = i;
		}

	}

	@Override
	public void union(int p, int q) {

		int pId = find(p);
		int qId = find(q);

		if (pId == qId) {
			return;
		}

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}

		count--;
	}

	@Override
	public int find(int p) {

		return id[p];
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
