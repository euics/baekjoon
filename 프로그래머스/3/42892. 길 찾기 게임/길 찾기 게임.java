import java.util.*;

class Solution {
	public int[][] solution(int[][] nodeinfo) {
		Node[] nodes = new Node[nodeinfo.length];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
		}
		Arrays.sort(nodes);

		Node root = constructTree(nodes);

		ArrayList<Integer> preOrders = new ArrayList<>();
		preOrder(root, preOrders);

		ArrayList<Integer> postOrders = new ArrayList<>();
		postOrder(root, postOrders);

		return new int[][] {
			preOrders.stream().mapToInt(i -> i).toArray(),
			postOrders.stream().mapToInt(i -> i).toArray()
		};
	}

	public Node constructTree(Node[] nodes) {
		Node root = nodes[0];

		for (int i = 1; i < nodes.length; i++) {
			insert(root, nodes[i]);
		}

		return root;
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

	public void preOrder(Node root, ArrayList<Integer> visits) {
		if (root == null) {
			return;
		}

		visits.add(root.value);
		preOrder(root.left, visits);
		preOrder(root.right, visits);
	}

	public void postOrder(Node root, ArrayList<Integer> visits) {
		if (root == null) {
			return;
		}

		postOrder(root.left, visits);
		postOrder(root.right, visits);
		visits.add(root.value);
	}
}

class Node implements Comparable<Node> {
	int value, x, y;
	Node left, right;

	public Node(int value, int x, int y) {
		this.value = value;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		if (this.y == o.y) {
			return this.x - o.x;
		} else {
			return o.y - this.y;
		}
	}
}