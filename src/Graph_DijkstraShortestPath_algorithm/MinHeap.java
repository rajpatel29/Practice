package Graph_DijkstraShortestPath_algorithm;

import java.util.HashMap;

public class MinHeap {
	Node[] nodeArray = null;
	int size = 0;
	int nextAvailablePosition = 0;
	HashMap<Integer, Integer> keyPosition = new HashMap<>();
	
	public MinHeap(int size) {
		this.size  =size;
		nodeArray = new Node[size];
	}
	
	public void put(int weight, int key) {
		if(nextAvailablePosition == size) {
			System.out.println("Heap is full");
		}
		
		nodeArray[nextAvailablePosition] = new Node(weight, key);
		keyPosition.put(key, nextAvailablePosition);
		int childIndex = nextAvailablePosition;
		nextAvailablePosition++;
		
		if(childIndex == 0) {
			return;
		} 
		
		int parentIndex = ( childIndex - 1 ) / 2;
		
		while(nodeArray[parentIndex].weight > nodeArray[childIndex].weight) {
			keyPosition.put(nodeArray[parentIndex].key, childIndex);
			keyPosition.put(nodeArray[childIndex].key, parentIndex);
			
			Node temp = nodeArray[parentIndex];
			nodeArray[parentIndex] = nodeArray[childIndex];
			nodeArray[childIndex] = temp;
			
			
			
			childIndex = parentIndex;
			parentIndex = ( childIndex - 1 ) / 2;		
		}
	}
	
	public void decreaseKey(int weight, int key) {
		if(!keyPosition.containsKey(key)) {
			System.out.println("No such key found");
			return;
		}
		
		int childIndex = keyPosition.get(key);
		nodeArray[childIndex].weight = weight;
		int parentIndex = ( childIndex - 1 ) / 2;
		
		while(nodeArray[parentIndex].weight > nodeArray[childIndex].weight) {
			keyPosition.put(nodeArray[parentIndex].key, childIndex);
			keyPosition.put(nodeArray[childIndex].key, parentIndex);
			
			Node temp = nodeArray[parentIndex];
			nodeArray[parentIndex] = nodeArray[childIndex];
			nodeArray[childIndex] = temp;
			
			childIndex = parentIndex;
			parentIndex = ( childIndex - 1 ) / 2;		
		}		
	}
	
	public Node delete() {
		if (nextAvailablePosition == 0) {
			System.out.println("No element in the heap");
			return null;
		}
		Node answer = null;
		answer = nodeArray[0];
		nodeArray[0] = nodeArray[nextAvailablePosition-1];
		nextAvailablePosition --;
		
		keyPosition.put(nodeArray[0].key, 0);
		keyPosition.remove(answer.key);
		
		nodeArray[nextAvailablePosition] = null;
		
		if (nextAvailablePosition == 0) {
			return answer;
		} else {
			
			int parentIndex = 0;
			int childIndex1 = (parentIndex * 2) +1;
			int childIndex2 = (parentIndex * 2) +2;
			
			while(true) {
				if(childIndex2 < nextAvailablePosition) {
					// 2 child
					int minChildWeight = Math.min(nodeArray[childIndex1].weight, nodeArray[childIndex2].weight);
					int minChildIndex;
					if(minChildWeight == nodeArray[childIndex1].weight) {
						minChildIndex = childIndex1;
					} else {
						minChildIndex = childIndex2;
					}
					
					if(nodeArray[minChildIndex].weight > nodeArray[parentIndex].weight) {
						break;
					}
					
					keyPosition.put(nodeArray[parentIndex].key, minChildIndex);
					keyPosition.put(nodeArray[minChildIndex].key, parentIndex);
					
					Node temp = nodeArray[parentIndex];
					nodeArray[parentIndex] = nodeArray[minChildIndex];
					nodeArray[minChildIndex] = temp;
					
					parentIndex = childIndex1;
					childIndex1 = (parentIndex * 2) +1;
					childIndex2 = (parentIndex * 2) +2;
					
				} else if(childIndex1 < nextAvailablePosition ) {
					if(nodeArray[childIndex1].weight < nodeArray[parentIndex].weight) {
						
						keyPosition.put(nodeArray[parentIndex].key, childIndex1);
						keyPosition.put(nodeArray[childIndex1].key, parentIndex);
						
						Node temp = nodeArray[parentIndex];
						nodeArray[parentIndex] = nodeArray[childIndex1];
						nodeArray[childIndex1] = temp;	
					}
					
					parentIndex = childIndex1;
					childIndex1 = (parentIndex * 2) +1;
					childIndex2 = (parentIndex * 2) +2;
					
				} else {
					break;
				}
			}	
		}
		
		return answer;
	}
	
	public boolean isEmpty() {
		return (nextAvailablePosition == 0);
	}
	
	public int currentWeight(int key) {
		
		return nodeArray[keyPosition.get(key)].weight;
	}
}
