package geekfor.geeks.lot;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalUsingQueue {

	public static void main(String[] args) {
		BinaryTree2 tree2 = new BinaryTree2();
		tree2.root = new Node2(1);

		tree2.root.left = new Node2(2);
		tree2.root.right = new Node2(3);

		tree2.root.left.left = new Node2(4);
		tree2.root.right.right = new Node2(5);

		tree2.printLevelOrder();
	}

}

class Node2 {
	int data;
	Node2 left;
	Node2 right;

	public Node2(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class BinaryTree2 {
	Node2 root;

	public void printLevelOrder() {
		Queue<Node2> queue = new LinkedList<Node2>();

		queue.add(root);
		while (!queue.isEmpty()) {

			Node2 temp_node = queue.poll();

			System.out.print(temp_node.data + ", ");

			if (temp_node.left != null) {
				queue.add(temp_node.left);
			}

			if (temp_node.right != null) {
				queue.add(temp_node.right);
			}
		}
	}
}