import java.util.*;

class Solution {
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    public int solution(int N, int[][] road, int K) {
        init(N, road);
        dijkstra(1);

        return countAnswer(K);
    }

    public void init(int N, int[][] roads) {
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<Edge>());
        for(int[] road : roads) {
            graph.get(road[0]).add(new Edge(road[1], road[2]));
            graph.get(road[1]).add(new Edge(road[0], road[2]));
        }
    }

    public void dijkstra(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(v, 0));
        dis[v] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(cur.c > dis[cur.v]) continue;

            for(Edge o : graph.get(cur.v)) {
                if(dis[o.v] > cur.c + o.c) {
                    dis[o.v] = cur.c + o.c;
                    pq.add(new Edge(o.v, cur.c + o.c));
                }
            }
        }
    }
    
    public int countAnswer(int K) {
        int answer = 0;
        for(int x : dis) if(x <= K) answer++;

        return answer;
    }
}

class Edge implements Comparable<Edge> {
    int v, c;
    public Edge(int v, int c) {
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Edge o) {
        return this.c - o.c;
    }
}