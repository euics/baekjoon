import java.util.*;

class Solution {
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
            String[] split = command.split(" ");
            char type = split[0].charAt(0);

            if (type == 'U') {
                int cnt = Integer.parseInt(split[1]);
                for (int i = 0; i < cnt; i++) cur = cur.prev;
            }

            if (type == 'D') {
                int cnt = Integer.parseInt(split[1]);
                for (int i = 0; i < cnt; i++) cur = cur.next;
            }

            if (type == 'C') {
                cur.removed = true;
                stack.push(cur);

                if (cur.prev != null) cur.prev.next = cur.next;
                if (cur.next != null) cur.next.prev = cur.prev;

                cur = (cur.next != null) ? cur.next : cur.prev;
            }

            if (type == 'Z') {
                Node removed = stack.pop();
                removed.removed = false;

                if (removed.prev != null) removed.prev.next = removed;
                if (removed.next != null) removed.next.prev = removed;
            }
        }

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) sb.append(nodes[i].removed ? 'X' : 'O');

        return sb.toString();
    }
}

class Node {
    Node next, prev;
    boolean removed;
}