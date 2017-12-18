package geekfor.geeks.lot;

public class BFS {

	public static void main(String ags[]) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.root = new MyNode(1);

		tree.root.left = new MyNode(2);
		tree.root.right = new MyNode(3);

		tree.root.left.left = new MyNode(4);
		tree.root.left.right = new MyNode(5);

		tree.printLevelOrder();

	}

}

class MyNode {
	int data;
	MyNode left;
	MyNode right;

	MyNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class MyBinaryTree {
	MyNode root;

	MyBinaryTree() {
		this.root = null;
	}

	public void printLevelOrder() {
		int level = getHeight(root);
		for (int l = 1; l <= level; l++) {
			printGivenLevel(root, l);
		}
	}

	public void printGivenLevel(MyNode root, int l) {
		if (root == null) {
			return;
		}

		if (l == 1) {
			System.out.print(root.data + ", ");
		} else if (l > 1) {
			printGivenLevel(root.left, l - 1);
			printGivenLevel(root.right, l - 1);
		}
	}

	public int getHeight(MyNode root) {
		if (root == null) {
			return 0;
		} else {
			int lh = getHeight(root.left);
			int rh = getHeight(root.right);
			if (lh > rh) {
				return lh + 1;
			} else {
				return rh + 1;
			}
		}
	}
}
