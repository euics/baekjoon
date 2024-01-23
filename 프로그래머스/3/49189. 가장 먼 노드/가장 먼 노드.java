import java.util.*;

class Solution {
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    public int solution(int n, int[][] edge) {
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<Edge>());

        for(int i = 0; i < edge.length; i++){
            graph.get(edge[i][0]).add(new Edge(edge[i][1], 1));
            graph.get(edge[i][1]).add(new Edge(edge[i][0], 1));
        }

        dijkstra(1);

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) max = Math.max(max, dis[i]);

        System.out.println(max);

        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(max == dis[i]) answer++;
        }

        return answer;
    }

    public void dijkstra(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dis[v] = 0;
        pq.add(new Edge(v, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(dis[cur.v] < cur.c) continue;

            for(Edge o : graph.get(cur.v)){
                if(dis[o.v] > cur.c + o.c){
                    dis[o.v] = cur.c + o.c;
                    pq.add(new Edge(o.v, cur.c + o.c));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int v, c;
    public Edge(int v, int c){
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Edge o){
        return this.c - o.c;
    }
}