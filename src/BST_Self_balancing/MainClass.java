package BST_Self_balancing;

// So the time complexity of AVL insert remains same as BST insert which is O(h) where h is the height of the tree.
public class MainClass {
	public static void main(String[] args) {
		SelfBST tree = new SelfBST(); 
		  
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 25); 
  
        
        tree.bfsTraversal(tree.root);
        System.out.println("Done!!");
	}
}
