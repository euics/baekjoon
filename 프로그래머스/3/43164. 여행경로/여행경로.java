import java.util.*;

class Solution {
    static Map<String, PriorityQueue<String>> graph;
    static LinkedList<String> answer;

    public String[] solution(String[][] tickets) {
        init(tickets);
        DFS("ICN");

        // LinkedList를 배열로 변환하여 반환 (역순으로 저장되었으므로 뒤집지 않음)
        return answer.toArray(new String[0]);
    }

    public void init(String[][] tickets) {
        answer = new LinkedList<>();
        graph = new HashMap<>();
        for (String[] ticket : tickets) {
            String pre = ticket[0];
            String next = ticket[1];

            graph.putIfAbsent(pre, new PriorityQueue<>());
            graph.get(pre).add(next);
        }
    }

    public void DFS(String pre) {
        while (graph.containsKey(pre) && !graph.get(pre).isEmpty()) {
            DFS(graph.get(pre).poll());
        }
        answer.addFirst(pre); // LinkedList의 맨 앞에 추가하여 역순으로 저장
    }
}
