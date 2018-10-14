package BST_One_Child_Check;

public class MainClass {
	public static void main(String[] args) {
		int inputs[] = {20, 10, 11, 13, 12};
	
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		boolean answer = true;
		int parent = inputs[0];
		
		for (int i = 1; i < inputs.length; i++) {
			if(!(min < inputs[i] && inputs[i] < max)) {
				answer = false;
				break;
			}
			if(parent < inputs[i]) {
				min = parent;
			} else {
				max = parent;
			}
			
			parent = inputs[i];
		}
		
		
		System.out.println(answer);
	}
}
