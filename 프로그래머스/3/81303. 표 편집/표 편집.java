import java.util.*;

class Solution {
    static StringBuilder ans = new StringBuilder();

    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        nodes[0] = new Node();
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].prev = nodes[i - 1];
            nodes[i - 1].next = nodes[i];
        }

        Node cur = nodes[k];
        Stack<Node> stack = new Stack<>();
        for (String command : cmd) {
            char type = command.split(" ")[0].charAt(0);

            if (type == 'D') {
                int cnt = Integer.parseInt(command.split(" ")[1]);
                for (int i = 0; i < cnt; i++) cur = cur.next;
            }

            if (type == 'U') {
                int cnt = Integer.parseInt(command.split(" ")[1]);
                for (int i = 0; i < cnt; i++) cur = cur.prev;
            }

            if (type == 'C') {
                cur.isDeleted = true;
                stack.push(cur);

                if (cur.prev != null) cur.prev.next = cur.next;
                if (cur.next != null) cur.next.prev = cur.prev;

                cur = cur.next != null ? cur.next : cur.prev;
            }

            if (type == 'Z') {
                Node deleted = stack.pop();
                deleted.isDeleted = false;

                if (deleted.prev != null) deleted.prev.next = deleted;
                if (deleted.next != null) deleted.next.prev = deleted;
            }
        }

        for (int i = 0; i < n; i++) ans.append(nodes[i].isDeleted ? 'X' : 'O');

        return ans.toString();
    }
}

class Node {
    Node prev, next;
    boolean isDeleted;
}