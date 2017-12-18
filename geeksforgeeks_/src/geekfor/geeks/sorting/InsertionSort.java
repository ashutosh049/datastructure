package geekfor.geeks.sorting;

import com.util.PrintUtil;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 9, 4, 10, 0 };

		System.out.println("Before Sorting...");
		PrintUtil.printArray(arr);

		insertionSort(arr);

		System.out.println("\nAfter Sorting...");
		PrintUtil.printArray(arr);

	}

	private static void insertionSort(int arr[]) {
		if (arr == null || arr.length < 2) {
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];

			// Comparison starts from one step back of element on which we are
			// working that is i.
			int j = i - 1;

			// Compare elements till we not found element higher than temp or
			// all element are compared.
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

}
