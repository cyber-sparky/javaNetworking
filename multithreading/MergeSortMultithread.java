package day01.practice;

public class MergeSortMultithread {
	/**
	 * a function for merging both arrays
	 * 
	 * @param arr
	 * @param left
	 * @param middle
	 * @param right
	 */
	public static void merge(int[] arr, int left, int middle, int right) {
		int[] b = new int[right - left + 1];

		int i = left, j = middle + 1, k = 0;

		while (i <= middle && j <= right) {
			if (arr[i] <= arr[j]) {
				b[k] = arr[i];
				i++;
			} else {
				b[k] = arr[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			b[k] = arr[i];
			i++;
			k++;
		}
		while (j <= right) {
			b[k] = arr[j];
			j++;
			k++;
		}

		for (i = left, k = 0; i <= right; i++, k++) {
			arr[i] = b[k];
		}
	}

	public static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			/**
			 * creating threads for each method
			 */
			Thread leftThread = new RunFaster(arr, left, middle);
			Thread rightThread = new RunFaster(arr, middle + 1, right);

//			starting threads
			leftThread.start();
			rightThread.start();

			try {
//				using join method to wait to run the merge method
				leftThread.join();
				rightThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			merge(arr, left, middle, right);
		}
	}

	public static void main(String[] args) {

//		starting the start time
		long startTime = System.nanoTime();
//		array 
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		calling the sort method
		sort(arr, 0, arr.length - 1);

//		printing the sorted arrya
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		long endTime = System.nanoTime();
		// calculating the end time
		double elapsedTimeInSeconds = (endTime - startTime) / 1e9;
		// printing how many second it took to sort
		System.out.println("Elapsed time in seconds: " + elapsedTimeInSeconds);
	}
}

/**
 * RunFaster class extends thread to run faster the methods
 * 
 * @author PranawMurugesan
 *
 */
class RunFaster extends Thread {
//	declaing attributes
	private int[] arr;
	private int left;
	private int right;

//	creating constructor
	public RunFaster(int[] arr, int left, int right) {
		this.arr = arr;
		this.left = left;
		this.right = right;
	}

//	whenever calling start method, this run method should execute
	@Override
	public void run() {
		MergeSortMultithread.sort(arr, left, right);
	}
}
