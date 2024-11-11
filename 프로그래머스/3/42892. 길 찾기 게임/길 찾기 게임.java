import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[][] solution(int[][] nodeinfo) {
		Node[] nodes = new Node[nodeinfo.length];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
		}
		Arrays.sort(nodes, (a, b) -> b.y - a.y);

		Node root = constructTree(nodes);

		ArrayList<Integer> preOrder = new ArrayList<>();
		preOrder(root, preOrder);

		ArrayList<Integer> postOrder = new ArrayList<>();
		postOrder(root, postOrder);

		return new int[][] {
			preOrder.stream().mapToInt(i -> i).toArray(),
			postOrder.stream().mapToInt(i -> i).toArray()
		};
	}

	public void insert(Node root, Node node) {
		if (node.x < root.x) {
			if (root.left == null) {
				root.left = node;
			} else {
				insert(root.left, node);
			}
		} else {
			if (root.right == null) {
				root.right = node;
			} else {
				insert(root.right, node);
			}
		}
	}

	public Node constructTree(Node[] nodes) {
		Node root = nodes[0];

		for (int i = 1; i < nodes.length; i++) {
			insert(root, nodes[i]);
		}

		return root;
	}

	public void preOrder(Node node, ArrayList<Integer> visits) {
		if (node == null)
			return;

		visits.add(node.value);
		preOrder(node.left, visits);
		preOrder(node.right, visits);
	}

	public void postOrder(Node node, ArrayList<Integer> visits) {
		if (node == null)
			return;

		postOrder(node.left, visits);
		postOrder(node.right, visits);
		visits.add(node.value);
	}
}

class Node {
	int value, x, y;
	Node left, right;

	public Node(int value, int x, int y) {
		this.value = value;
		this.x = x;
		this.y = y;
	}
}