import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> tree;
	static boolean[] bool;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		for (int i = 0; i < N; i++)
			tree.add(new ArrayList<Integer>());
		bool = new boolean[N];

		int root = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1)
				root = i;
			else
				tree.get(parent).add(i);
		}

		int deleteNode = Integer.parseInt(br.readLine());
		deleteTree(deleteNode);

		if (deleteNode == root)
			System.out.println(0);
		else
			System.out.println(countLeafNodes(root));
	}

	public static void deleteTree(int node) {
		bool[node] = true;
		for (int child : tree.get(node)) {
			if (!bool[child])
				deleteTree(child);
		}
	}

	public static int countLeafNodes(int node) {
		if (bool[node])
			return 0;
		if (tree.get(node).isEmpty())
			return 1;

		int leafCount = 0;
		boolean hasChild = false;
		for (int child : tree.get(node)) {
			if (!bool[child]) {
				hasChild = true;
				leafCount += countLeafNodes(child);
			}
		}

		return hasChild ? leafCount : 1;
	}
}