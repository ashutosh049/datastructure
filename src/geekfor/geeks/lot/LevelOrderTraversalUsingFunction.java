package geekfor.geeks.lot;

/**
 * Recursive Java program for level order traversal of Binary Tree Time
 * Complexity: O(n^2) in worst case. 
 * For a skewed tree, printGivenLevel() takes
 * O(n) time where n is the number of nodes in the skewed tree. 
 * So time
 * complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which
 * is O(n^2).
 */
public class LevelOrderTraversalUsingFunction {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}

}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	public BinaryTree() {
		root = null;
	}

	void printLevelOrder() {
		int height = getHeight(root);
		for (int h = 1; h <= height; h++) {
			printGivenLevel(root, h);

		}
	}

	private void printGivenLevel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.data);
		} else if (level > 1) {
			
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}

	}

	int getHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			int lHeight = getHeight(root.left);
			int rHeight = getHeight(root.right);

			if (lHeight > rHeight)
				return lHeight + 1;
			else
				return rHeight + 1;

		}
	}
}