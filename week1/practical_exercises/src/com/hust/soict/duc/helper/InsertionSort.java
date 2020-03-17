package com.hust.soict.duc.helper;

public class InsertionSort implements NumberSorter {
	@Override
	public void sort(int[] intarr) {
		for (int i = 1; i < intarr.length; i++) {
			int k = i;
			int j = i - 1;
			while (j >= 0) {
				if (intarr[k] < intarr[j]) {
					int temp = intarr[j];
					intarr[j] = intarr[k];
					intarr[k] = temp;
					k--;
				}
				j--;
			}
		}
	}
}
