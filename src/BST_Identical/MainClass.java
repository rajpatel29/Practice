// I. M. P.

//Given two arrays which represent a sequence of keys. Imagine we make a Binary Search Tree (BST) from each array. We need to tell whether two BSTs will be identical or not without actually constructing the tree.
//Examples
//For example, the input arrays are {2, 4, 3, 1} and {2, 1, 4, 3} will construct the same tree

package BST_Identical;

public class MainClass {
	public static void main(String[] args) {
//		int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
//		int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
		
		int a[] = {2,4,3,1};
		int b[] = {2,1,4,3};
		
		System.out.println("Is same? " + isSameBST(a, b));
	}

	private static boolean isSameBST(int[] a, int[] b) {
		if(a.length != b.length)
			return false;
		
		return isSameBSTHelper(a,b,0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, a.length);
	}

	private static boolean isSameBSTHelper(int[] a, int[] b, int startIndex1, int startIndex2, int minValue, int maxValue, int length) {
		System.out.println("min: " + minValue + " max: " + maxValue);
		
		int i, j;
		for (i = startIndex1; i < a.length; i++) {
			if(minValue < a[i] && a[i] < maxValue) {
				break;
			}
		}
		
		
		for (j = startIndex2; j < a.length; j++) {
			if(minValue < b[j] && b[j] < maxValue) {
				System.out.println("i " + j);
				break;
			}
		}

		if((i == length && j == length))
			return true;
		
		if(a[i] != b[j]) {
			return false;
		}
		
		if((i != length && j == length) || (j != length && j == length))
			return false;

		
		return isSameBSTHelper(a, b, i, j , a[i], maxValue, length) &&
				isSameBSTHelper(a, b, i, j , minValue, a[i], length);
	}
}
