package cn.johnson.algorithm.applications;

import java.util.Scanner;

public class MaxSubSequenceSum {
	public static void main(String[] args) {
		int[] array = null; // { 1, 3, 2, -2, 4, -1, 6 };

		int n = 0;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}

		System.out.println("max sum of subsequences :"
				+ maxSubSequenceSum(array));

		System.out.println("max sum of subsequences :"
				+ maxSubSequenceSum2(array));

		System.out.println("max sum of subsequences :"
				+ maxSubSequenceSum3(array));

		System.out.println("max sum of subsequences :"
				+ maxSubSequenceSum4(array));
	}

	private static int maxSubSequenceSum(int[] array) {
		int maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				int thisSum = 0;
				for (int k = i; k <= j; k++) {
					thisSum += array[k];
					if (thisSum > maxSum) {
						maxSum = thisSum;
					}
				}
			}
		}

		return maxSum;
	}

	/**
	 * 从第一个算法改进而来，第三重循环重复地计算相同的序列没有必要
	 * 
	 * @param array
	 * @return
	 */
	public static int maxSubSequenceSum2(int[] array) {
		int maxSum = 0;

		for (int i = 0; i < array.length; i++) {
			int thisSum = 0;
			for (int j = i; j < array.length; j++) {
				thisSum += array[j];
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}

		return maxSum;
	}

	/**
	 * 由O(N^2)继而想到是否可以简化成N.log N
	 * 
	 * @param array
	 * @return
	 */
	public static int maxSubSequenceSum3(int[] array) {

		return maxSubSequenceSum(array, 0, array.length - 1);

	}

	private static int maxSubSequenceSum(int[] array, int start, int end) {
		if (end <= start) {
			return array[start] < 0 ? 0 : array[start];
		}
		int mid = start + (end - start) / 2;
		/* 查找左边子序列的最大和 */
		int maxLeft = maxSubSequenceSum(array, start, mid);
		/* 查找右边子序列的最大和 */
		int maxRight = maxSubSequenceSum(array, mid + 1, end);

		int maxBoarderLeft = 0;
		/* 查找跨越边界的最大和 */
		int sum = 0;
		for (int i = mid; i >= start; i--) {
			sum += array[i];
			if (maxBoarderLeft < sum) {
				maxBoarderLeft = sum;
			}
		}

		int maxBoarderRight = 0;
		sum = 0;
		for (int i = mid + 1; i <= end; i++) {
			sum += array[i];
			if (maxBoarderRight < sum) {
				maxBoarderRight = sum;
			}
		}

		return max3(maxLeft, maxRight, maxBoarderLeft + maxBoarderRight);
	}

	/**
	 * 在线处理 O(N)
	 * 
	 * @param array
	 * @return
	 */
	private static int maxSubSequenceSum4(int[] array) {
		int thisSum = 0, maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			thisSum += array[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			} else if (thisSum < 0) {
				thisSum = 0;
			}
		}

		return maxSum;
	}

	private static int max3(int a, int b, int c) {

		if (a > b) {
			if (a > c) {
				return a;
			} else {
				return c;
			}
		} else {
			if (b > c) {
				return b;
			} else {
				return c;
			}
		}
		/*
		 * if(a<b){ a=b; }
		 * 
		 * if(a>c){ return a; }else{ return c; }
		 */
	}

}
