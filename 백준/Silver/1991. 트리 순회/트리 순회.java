import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());

		BinaryTree tree = new BinaryTree();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char value = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			tree.insert(value, left, right);
		}

		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		System.out.println();
	}
}

class Node {
	char val;
	Node left, right;

	public Node(char val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	Node root;

	public void insert(char val, char left, char right) {
		if (root == null) {
			root = new Node(val);

			if (left != '.')
				root.left = new Node(left);
			if (right != '.')
				root.right = new Node(right);
		} else
			search(root, val, left, right);
	}

	public void search(Node root, char val, char left, char right) {
		if (root == null)
			return;

		if (root.val == val) {
			if (left != '.')
				root.left = new Node(left);
			if (right != '.')
				root.right = new Node(right);
		} else {
			search(root.left, val, left, right);
			search(root.right, val, left, right);
		}
	}

	public void preOrder(Node node) {
		if (node == null)
			return;

		System.out.print(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.val);
		inOrder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val);
	}
}