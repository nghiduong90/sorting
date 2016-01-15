package sorting;

import java.util.Arrays;

public class Sorting {

	/**
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSort (int[] arr, int low, int high) {
		if (arr == null || arr.length == 0) {
			return;
		}
		
		if (low >= high) {
			return;
		}
		
		System.out.println("Sort array " + Arrays.toString(arr) + "\t from " + low + " to " + high);
		// pick pivot
		int middle = (low + high) / 2;
		int pivot = arr[middle];
		
		System.out.println ("pick pivot = " + pivot);
		int i = low;
		int j = high;
		
		// make left < pivot, right > pivot
		while (i <= j) {
			System.out.println ("\ti = " + i + "\tj = " + j); 
			while (arr[i] < pivot) {
				i++;
				System.out.println ("value of i after increment in first loop is   " + i);
			}
			System.out.println ("\t\t low is " + low + ", and i after first loop is " + i);
			while (arr[j] > pivot) {
				j--;
				System.out.println ("value of j after decrement in first loop is   " + j);
			}
			System.out.println ("\t\t high is " + high + ", and j after first loop is " + j);
			if (i <= j) {
				System.out.println ("\t\tSwapping " + arr[i] + " and " + arr[j]);
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		System.out.println("Array after while loop " + Arrays.toString(arr));
		System.out.println ("low = " + low + "   j = " + j);
		if (low < j) {
			System.out.println ("\t now sorting from (low to j) " + low + " to " + j);
			quickSort (arr, low, j);
		}
		
		System.out.println("Array after sorting from " + low + " to " + j + Arrays.toString(arr));
		if (high > i) {
			System.out.println ("\t now sorting from (i to high) " + i + " to " + high);
			quickSort (arr, i, high);
		}
		
		System.out.println("Array after sorting from " + i + " to " + high + Arrays.toString(arr));
		
		System.out.println ("RETURNING FROM RECURSION...");
	}
	
	
	public static void mergeSort (int[] arr) {
		int[] temp = new int [arr.length];
		mergeSort (arr, temp, 0, arr.length - 1);
	}
	
	private static void mergeSort(int[] arr, int[] temp, int left, int right) {
		System.out.println ("left = " + left + "\tright = " + right + "\tof the array " + Arrays.toString(arr));
		if (left < right) {
			int middle = (left + right) / 2;
			System.out.println ("\tmiddle = " + middle);
			System.out.println ("\tcalling mersort from " + left + " to " + middle);
			mergeSort (arr, temp, left, middle);
			System.out.println ("\tcalling mersort from " + (middle + 1) + " to " + right);
			mergeSort (arr, temp, middle + 1, right);
			System.out.println ("Merge array from left = " + left + " to right = " + (middle + 1) + ", with rightEnd = " + right);
			merge (arr, temp, left, middle + 1, right);
		}
	}


	private static void merge(int[] arr, int[] temp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;
		
		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[k++] = arr[left++];
				System.out.println ("\t\t\tCopy in loop from left:");
				System.out.println ("\t\t\t\t " + Arrays.toString(temp));
			} else {
				temp[k++] = arr[right++];
				System.out.println ("\t\t\tCopy in loop from right:");
				System.out.println ("\t\t\t\t " + Arrays.toString(temp));
			}
		}
		
		while (left <= leftEnd) {
			temp[k++] = arr[left++];
			System.out.println ("\t\t\tCopy from left:");
			System.out.println ("\t\t\t\t " + Arrays.toString(temp));
		}
		
		while (right <= rightEnd) {
			temp[k++] = arr[right++];
			System.out.println ("\t\t\tCopy from right:");
			System.out.println ("\t\t\t\t " + Arrays.toString(temp));
		}
		
		for (int i = 0; i < num; i++, rightEnd--) {
			arr[rightEnd] = temp[rightEnd];
			System.out.println ("Copy back to array \t\t" + Arrays.toString(arr));
			
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1};
		quickSort(arr, 0, 3);
		System.out.println (Arrays.toString(arr));

	}

}
