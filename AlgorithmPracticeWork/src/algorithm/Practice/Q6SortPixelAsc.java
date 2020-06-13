package algorithm.Practice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

/**
 *
 * @author Shivi
 */
class MergeSort {
	/**
	 * mergeSort to divide array recursively
	 * 
	 * @param array Array of pixel Intensity
	 * @param start start index of array
	 * @param end   end index of array
	 */
	static void mergeSort(double[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(array, start, middle);
			mergeSort(array, middle + 1, end);
			merge(array, start, middle, end);

		}
	}

	/**
	 * merge function to sort two arrays and merge them
	 * 
	 * @param arr Array of pixel Intensity
	 * @param l   start index of array
	 * @param m   middle index of array
	 * @param r   end index of array
	 */
	static void merge(double[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
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

			if (R[j] < (L[i])) {
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
}

class HeapSort {
	/**
	 * Heapify subtree rooted with node i
	 * 
	 * @param array
	 * @param n     size of heap
	 * @param i     node i of heap
	 */
	public void heapify(double array[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && array[l] >= array[largest]) {
			largest = l;
		}
		if (r < n && array[r] >= array[largest]) {
			largest = r;
		}
		if (largest != i) {
			double swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;

			heapify(array, n, largest);
		}
	}

	/**
	 * HeapsSort to traverse heap and put lowest value on root nodes
	 * 
	 * @param array array to heapsort
	 */
	public void heapSort(double[] array) {
		int n = array.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(array, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			double temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, i, 0);
		}
	}

	/* A utility function to print array of size n */
	void printArray(double arr[], int n) {
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

public class Q6SortPixelAsc {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
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
			System.out.println("Question 6:");

			/**
			 * Merge sort to find sorted pixel array
			 */
			System.out.println("Image Pixels in ascending using MergeSort");
			MergeSort mergeSortObj = new MergeSort();
			mergeSortObj.mergeSort(pixelIntensity, 0, pixelIntensity.length - 1);
			for (int g = 0; g < pixelIntensity.length; g++) {
				System.out.print(pixelIntensity[g] + " ");
			}
			System.out.println();
			System.out.println("-------------------------------");

			/**
			 * Heap sort to find sorted pixel array
			 */
			System.out.println("Image Pixels in ascending using heapSort");
			HeapSort heapSortObj = new HeapSort();
			heapSortObj.heapSort(pixelIntensity);
			System.out.println();
			heapSortObj.printArray(pixelIntensity, n);

			System.out.println("-------------------------------");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
