import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        LinkedList<String> answer = new LinkedList<>();
        Map<String, PriorityQueue<String>> flights = new HashMap<>();

        for(String[] ticket : tickets){
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }

        DFS("ICN", flights, answer);

        return answer.stream().map(i -> i).toArray(String[]::new);
    }

    public void DFS(String departure, Map<String, PriorityQueue<String>> flights, LinkedList<String> answer){
        PriorityQueue<String> arrivals = flights.get(departure);

        while(arrivals != null && !arrivals.isEmpty()) DFS(arrivals.poll(), flights, answer);

        answer.addFirst(departure);
    }
}