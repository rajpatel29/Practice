package Sorting;

//					Best		Average		Worst
//Bubble Sort		Ω(n)		Θ(n^2)		O(n^2)	
//Insertion Sort	Ω(n)		Θ(n^2)		O(n^2)
//Selection Sort	Θ(n^2)		Θ(n^2)		O(n^2)
//merge Sort		θ(nlog(n))	θ(n log(n))	θ(n log(n))
//quick Sort		θ(nlog(n))	θ(n log(n))	θ(n^2)
//heap Sort			θ(nlog(n))	θ(n log(n))	θ(n log(n))

public class MainClass {
	public static void main(String[] args) {
		int[] inputes = {38, 27, 43, 3, 9, 82, 10};
		
//		bubbleSort(inputes);
		
//		insertionSort(inputes);
		
//		selectionSort(inputes);
		
//		mergeSort(inputes, 0, inputes.length-1);
		
//		quickSort(inputes, 0, inputes.length-1);
		
		for (int i = 0; i < inputes.length; i++) {
			System.out.println(inputes[i]);
		}
	}
	
	
	private static void quickSort(int[] inputes, int start, int end) {
		if(start > end)
			return;
		
		int pivot = quickSortHelper(inputes, start, end-1, end);
		
		quickSort(inputes, start, pivot-1);
		quickSort(inputes, pivot+1, end);
	}


	private static int quickSortHelper(int[] inputes, int start, int end, int pivot) {
		int wall = start;
		
		for (int i = start; i <= end; i++) {
			if(inputes[i] < inputes[pivot]) {
				int temp = inputes[i];
				inputes[i] = inputes[wall];
				inputes[wall] = temp;
				wall++;
			}
		}
		
		int temp = inputes[pivot];
		inputes[pivot] = inputes[wall];
		inputes[wall] = temp;
		
		return wall;
	}


	private static void mergeSort(int[] inputes, int start, int end) {
		if(start >= end)
			return;
		
		int mid = start + ((end - start) /2);
		
		mergeSort(inputes, start, mid);
		mergeSort(inputes, mid + 1, end);
		
		for (int i = start; i <= mid; i++) {
			for (int j = mid+1; j <= end; j++) {
				if(inputes[i] > inputes[j]) {
					int temp = inputes[i];
					inputes[i] = inputes[j];
					inputes[j] = temp;
				}
			}
		}
	}



	private static void selectionSort(int[] inputes) {
		for (int i = 0; i < inputes.length; i++) {
			int tempIndex = i;
			for (int j = i+1; j < inputes.length; j++) {
				if(inputes[tempIndex] > inputes[j]) {
					tempIndex = j;
				}
			}
			int temp = inputes[tempIndex];
			inputes[tempIndex] = inputes[i];
			inputes[i] = temp;
		}
	}

	private static void insertionSort(int[] inputes) {
		for (int i = 1; i < inputes.length; i++) {
			for (int j = i; j > 0; j--) {
				if(inputes[j-1] > inputes[j]) {
					int temp = inputes[j];
					inputes[j] = inputes[j-1];
					inputes[j-1] = temp;
				} else {
					break;
				}
			}
		}
	}

	private static void bubbleSort(int[] inputes) {
		for (int i = 0; i < inputes.length - 1; i++) {
			for (int j = 0; j < inputes.length - 1 - i; j++) {
				if(inputes[j] > inputes[j+1]) {
					int temp = inputes[j];
					inputes[j] = inputes[j+1];
					inputes[j+1] = temp;
				}
			}
		}
	}
}
