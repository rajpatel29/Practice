package Array_Search_in_Sorted_and_Rotated;

public class MainClass {
	public static void main(String[] args) {
		int inputs[] = {5, 6, 7, 8, 9,10, 1,2,3,4};
		int target = 1;
		
		int pivot = findPivot(inputs, 0, inputs.length-1);
		
		int answer;
		if(target > inputs[0]) {
			answer = findIndex(inputs, 0 , pivot, target);
		} else {
			answer = findIndex(inputs, pivot, inputs.length-1, target);
		}
		System.out.println(answer);
	}
	
	private static int findIndex(int[] inputs, int startIndex, int endIndex, int target) {
		if(startIndex > endIndex) {
			return -1;
		}
		int mid = (startIndex + endIndex) / 2;
		
		if(inputs[mid] == target) {
			return mid;
		}
		
		int leftResult = findIndex(inputs, startIndex, mid-1, target);
		int rightResult = findIndex(inputs, mid+1, endIndex, target);
		
		if(leftResult == -1) {
			return rightResult;
		} else {
			return leftResult;
		}
	}

	public static int findPivot(int[] inputs, int startIndex, int endIndex) {
		if(startIndex > endIndex) {
			return -1;
		}
		
		int mid = (startIndex + endIndex) / 2;

		if(mid != 0 && mid != inputs.length -1 && inputs[mid -1] < inputs[mid] && inputs[mid + 1] < inputs[mid] ) {
			return mid;
		}
		
		int leftResult = findPivot(inputs, startIndex, mid-1);
		int rightResult = findPivot(inputs, mid+1, endIndex);
		
		if(leftResult == -1) {
			return rightResult;
		} else {
			return leftResult;
		}
		
	}
}
