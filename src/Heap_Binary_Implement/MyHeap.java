package Heap_Binary_Implement;

public class MyHeap {
	private int capacity;
	private int elements[];
	private int lastElementIndex = 0;
	
	public MyHeap(int capacity) {
		this.capacity = capacity;
		this.elements = new int[capacity];
	}
	
	public void insert(int newElement) {
		if(lastElementIndex == capacity) {
			System.out.println("Can not be inserted b/c capacity is full");
		}
		
		int childIndex = lastElementIndex;

		elements[childIndex] = newElement;
		lastElementIndex++;
		
		if(childIndex == 0) {
			return;
		}
		
		int parentIndex = ((childIndex - 1) / 2);
		
		while(elements[parentIndex] < elements[childIndex]) {
			int temp = elements[parentIndex];
			elements[parentIndex] = elements[childIndex];
			elements[childIndex] = temp;
			
			childIndex = parentIndex;
			parentIndex = ((childIndex - 1) / 2);
			
			if(childIndex == 0)
				break;
		}
	}
	
	public int delete() {
		if(lastElementIndex == 0) {
			System.out.println("there is no element in the heap");
			return -1;
		}
		
		int result = elements[0];
		
		if(lastElementIndex == 1) {
			elements[0] = 0;
			lastElementIndex = 0;
			return result;
		}
		
		int temp = elements[lastElementIndex - 1];
		elements[lastElementIndex - 1] = 0;
		elements[0] = temp;
		lastElementIndex--;
		
		int parentIndex = 0;
		int childIndex1 = 1;
		int childIndex2 = 2;
		
		
		while(true) {
			if(lastElementIndex <= childIndex1 ) {
				//no child
				break;
			} else {
				if(lastElementIndex <= childIndex2 ) {
					// 1 child
					break;
				} else {
					int max = Math.max(elements[childIndex1], elements[childIndex2]);
					if(elements[parentIndex] > max){
						break;
					}
					
					int biggerChildIndex;
					if(max == elements[childIndex1]) {
						biggerChildIndex = childIndex1; 
					} else {
						biggerChildIndex = childIndex2;
					}
					
					int temp2 = elements[biggerChildIndex];
					elements[biggerChildIndex] = elements[parentIndex];
					elements[parentIndex] = temp2;
					
					parentIndex = biggerChildIndex;
					childIndex1 = (parentIndex * 2) + 1;
					childIndex2 = (parentIndex * 2) + 2;
				}
			}
		}
			
		return result;
	}
	
	public void showArray() {
		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
		}
	}
}
