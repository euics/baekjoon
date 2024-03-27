import java.util.*;

class Solution {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public int solution(int n, int[][] edge) {
        initDis(n);
        initGraph(n, edge);
        dijkstra();
        
        return getMaxLengthNode(n, getMaxLength(n));
    }

    public void initDis(int n) {
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
    }

    public void initGraph(int n, int[][] edge) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];

            graph.get(v1).add(new Edge(v2, 1));
            graph.get(v2).add(new Edge(v1, 1));
        }
    }

    public void dijkstra() {
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(1, 0));
        dis[1] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            for(Edge o : graph.get(cur.v)) {
                if(dis[o.v] > cur.c + o.c) {
                    dis[o.v] = cur.c + o.c;
                    q.add(new Edge(o.v, cur.c + o.c));
                }
            }
        }
    }

    public int getMaxLength(int n) {
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) max = Math.max(max, dis[i]);

        return max;
    }

    public int getMaxLengthNode(int n, int max) {
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(dis[i] == max) cnt++;
        }
        
        return cnt;
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