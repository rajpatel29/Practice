package Heap_Binary_Implement;

public class MainClass {
	public static void main(String[] args) {
		MyHeap myHeap = new MyHeap(8);
		
		myHeap.insert(90);
		myHeap.insert(45);
		myHeap.insert(60);
		myHeap.insert(101);
		myHeap.insert(55);
		myHeap.insert(61);
		
//		myHeap.showArray();
		System.out.println(myHeap.delete());
		System.out.println(myHeap.delete());
		System.out.println(myHeap.delete());
		System.out.println(myHeap.delete());
		System.out.println(myHeap.delete());
		System.out.println(myHeap.delete());
	}
}
