package algorithm.Practice;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;

class QuickSort {
	/**
	 * QuickSort function to divide array by pivot recursively
	 * 
	 * @param array array index to divide
	 * @param start start index of array
	 * @param end   end of array
	 */
	static void quickSort(double[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot + 1, end);
		}
	}

	static void quickSortRandomPivot(double[] array, int start, int end) {
		if (start < end) {

			Random rand = new Random();
			int random = rand.nextInt(end - start) + start;
			double temp1 = array[random];
			array[random] = array[end];
			array[end] = temp1;
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot + 1, end);
		}
	}

	/**
	 * Return pivot element and place all elements smaller than pivot towards left
	 * of pivot and bigger towards right of pivot
	 * 
	 * @param array array elements
	 * @param start start index of array
	 * @param end   end index of array
	 * @return pivot element to partition
	 */
	static int partition(double[] array, int start, int end) {
		double pivot = array[start];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j] >= pivot) {
				i++;
				double temp = array[i];
				array[i] = array[j];
				array[j] = temp;

			}
		}
		double temp = array[i + 1];
		array[i + 1] = array[start];
		array[start] = temp;
		System.out.println("pivot " + (i + 1));
		return i + 1;
	}

	/* A utility function to print array of size n */
	static void printArray(double arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

class SelectionSort {

	public void sortDescending(final double[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int maxElementIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[maxElementIndex] < arr[j]) {
					maxElementIndex = j;
				}
			}

			if (maxElementIndex != i) {
				double temp = arr[i];
				arr[i] = arr[maxElementIndex];
				arr[maxElementIndex] = temp;
			}
		}
	}
}

class BubbleSort {
	public void bubbleSort(double arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] < arr[j + 1]) {
					// swap arr[j+1] and arr[i]
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

}

class InsertionSort {
	/* Function to sort array using insertion sort */
	void sort(double arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			double key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
}

class TimSort {

	static int RUN = 32;

	// this function sorts array from left index to
	// to right index which is of size atmost RUN
	public static void insertionSort(double[] arr, int left, int right) {
		for (int i = left + 1; i < right; i++) {
			double temp = arr[i];
			int j = i - 1;
			while (j >= left && arr[j] < temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	// merge function merges the sorted runs
	static void merge(double[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		System.out.println(n2 + "= array size");
		System.out.println(r + " = r value ");
		System.out.println(m + " = m value ");
		if (n2 > 0) {
			double[] L = new double[n1];
			double[] R = new double[n2];

			/* Copy data to temp arrays */
			for (int i = 0; i < n1; ++i)
				L[i] = arr[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = arr[m + 1 + j];

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarry array
			int k = l;
			while (i < n1 && j < n2) {

				if (R[j] >= (L[i])) {
					arr[k] = R[j];
					j++;
				} else {
					arr[k] = L[i];
					i++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}

//		/* Create temp arrays */
//		double[] L = new double[n1];
//		double[] R = new double[n2];

	}

	// iterative Timsort function to sort the
	// array[0...n-1] (similar to merge sort)
	public static void timSort(double[] arr, int n) {

		// Sort individual subarrays of size RUN
		for (int i = 0; i < n; i += RUN) {

			insertionSort(arr, i, Math.min((i + 31), (n - 1)));

		}

		// start merging from size RUN (or 32). It will merge
		// to form size 64, then 128, 256 and so on ....
		for (int size = RUN; size < n; size = 2 * size) {

			// pick starting point of left sub array. We
			// are going to merge arr[left..left+size-1]
			// and arr[left+size, left+2*size-1]
			// After every merge, we increase left by 2*size
			for (int left = 0; left < n; left += 2 * size) {

				// find ending point of left sub array
				// mid+1 is starting point of right sub array
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (n - 1));

				// merge sub array arr[left.....mid] &
				// arr[mid+1....right]
				merge(arr, left, mid, right);
			}
		}
	}
}

class TimSort64 {

	static int RUN = 64;

	// this function sorts array from left index to
	// to right index which is of size atmost RUN
	public static void insertionSort(double[] arr, int left, int right) {
		for (int i = left + 1; i < right; i++) {
			double temp = arr[i];
			int j = i - 1;
			while (j >= left && arr[j] < temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	// merge function merges the sorted runs
	static void merge(double[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		if (n2 > 0) {
			double[] L = new double[n1];
			double[] R = new double[n2];

			/* Copy data to temp arrays */
			for (int i = 0; i < n1; ++i)
				L[i] = arr[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = arr[m + 1 + j];

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarry array
			int k = l;
			while (i < n1 && j < n2) {

				if (R[j] >= (L[i])) {
					arr[k] = R[j];
					j++;
				} else {
					arr[k] = L[i];
					i++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}

//		/* Create temp arrays */
//		double[] L = new double[n1];
//		double[] R = new double[n2];

	}

	// iterative Timsort function to sort the
	// array[0...n-1] (similar to merge sort)
	public static void timSort(double[] arr, int n) {

		// Sort individual subarrays of size RUN
		for (int i = 0; i < n; i += RUN) {

			insertionSort(arr, i, Math.min((i + 63), (n - 1)));

		}

		// start merging from size RUN (or 32). It will merge
		// to form size 64, then 128, 256 and so on ....
		for (int size = RUN; size < n; size = 2 * size) {

			// pick starting point of left sub array. We
			// are going to merge arr[left..left+size-1]
			// and arr[left+size, left+2*size-1]
			// After every merge, we increase left by 2*size
			for (int left = 0; left < n; left += 2 * size) {

				// find ending point of left sub array
				// mid+1 is starting point of right sub array
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (n - 1));

				// merge sub array arr[left.....mid] &
				// arr[mid+1....right]
				merge(arr, left, mid, right);
			}
		}
	}
}

public class Q4SortPixelAssign5 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		File file = new File(Paths.get("").toAbsolutePath().toString() + "/Boston.jpeg");

		BufferedImage image = null;

		try {
			image = ImageIO.read(file);
			int w = image.getWidth();
			int h = image.getHeight();
			double[] pixelIntensity = new double[w * h];
			int k = 0;
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					Color c = new Color(image.getRGB(i, j));
					int red = c.getRed();
					int green = c.getGreen();
					int blue = c.getBlue();
					pixelIntensity[k] = 0.2989 * red + 0.5870 * green + 0.1140 * blue;
					k++;
				}
			}
			int n = pixelIntensity.length;
			System.out.println("Question 4:");
			/**
			 * Quick sort using Random Pivot to find sorted pixel array
			 */
			System.out.println("Image Pixels in descending using quickSort Random");
			QuickSort quickSort = new QuickSort();
			quickSort.quickSortRandomPivot(pixelIntensity, 0, n - 1);
			System.out.println();
			quickSort.printArray(pixelIntensity);
			/**
			 * Quick sort to find sorted pixel array
			 */
			System.out.println("-------------------------------");

			System.out.println("Image Pixels in descending using quickSort");
			QuickSort quickSort1 = new QuickSort();
			quickSort1.quickSort(pixelIntensity, 0, n - 1);
			System.out.println();
			quickSort1.printArray(pixelIntensity);

			System.out.println("-------------------------------");

			/**
			 * Insertion sort to find sorted pixel array
			 */
			System.out.println("-------------------------------");

			System.out.println("Image Pixels in descending using Insertion Sort");
			InsertionSort insertion = new InsertionSort();
			insertion.sort(pixelIntensity);
			System.out.println();
			for (int g = 0; g < pixelIntensity.length; g++) {
				System.out.println(pixelIntensity[g] + " ");
			}

			System.out.println("-------------------------------");

			/**
			 * Bubble sort to find sorted pixel array
			 */
			System.out.println("-------------------------------");

			System.out.println("Image Pixels in descending using Bubble Sort");
			BubbleSort bubbleSort = new BubbleSort();
			bubbleSort.bubbleSort(pixelIntensity);
			System.out.println();
			for (int g = 0; g < pixelIntensity.length; g++) {
				System.out.println(pixelIntensity[g] + " ");
			}

			System.out.println("-------------------------------");

			/**
			 * Tim sort to find sorted pixel array min size 32
			 */
			System.out.println("-------------------------------");

			System.out.println("Image Pixels in descending using Tim Sort" + pixelIntensity.length);
			TimSort timSort = new TimSort();
			timSort.timSort(pixelIntensity, n);
			System.out.println();

			for (int g = 0; g < pixelIntensity.length; g++) {
				System.out.print(pixelIntensity[g] + " ");
			}

			System.out.println("-------------------------------");

			/**
			 * Tim sort to find sorted pixel array min size 64
			 */
			System.out.println("-------------------------------");

			System.out.println("Image Pixels in descending using Tim Sort" + pixelIntensity.length);
			TimSort64 timSort64 = new TimSort64();
			timSort64.timSort(pixelIntensity, n);
			System.out.println();

			for (int g = 0; g < pixelIntensity.length; g++) {
				System.out.print(pixelIntensity[g] + " ");
			}

			System.out.println("-------------------------------");

			/**
			 * Selection sort to find sorted pixel array
			 */
			System.out.println("Image Pixels in descending using SelectionSort");
			SelectionSort selectionSortObj = new SelectionSort();
			selectionSortObj.sortDescending(pixelIntensity);
			System.out.println();
			for (int g = 0; g < pixelIntensity.length; g++) {
				System.out.print(pixelIntensity[g] + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
