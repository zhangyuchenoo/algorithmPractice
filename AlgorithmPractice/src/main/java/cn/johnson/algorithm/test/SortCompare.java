package cn.johnson.algorithm.test;

import cn.johnson.algorithm.stdlib.StdOut;
import cn.johnson.algorithm.stdlib.StdRandom;

public class SortCompare {
	public static Double timeRandomInput(String alg, int n, int t) {
		// use alg to sort t random arrays of length n
		Double total = 0.0;
		Double[] a = new Double[n];
		for (int i = 0; i < t; i++) {
			for (int k = 0; i < n; i++) {
				a[k] = StdRandom.uniform();
				total += time(alg, a);
			}
		}

		return total;
	}

	private static Double time(String alg, Double[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T); // total for alg1
		double t2 = timeRandomInput(alg2, N, T); // total for alg2
		StdOut.printf("For %d random Doubles\n %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
	}
}
