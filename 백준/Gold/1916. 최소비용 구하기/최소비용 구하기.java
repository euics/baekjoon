import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<ArrayList<Edge>>();

        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<Edge>());

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()))
                    .add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dis[end]);
    }

    private static void dijkstra(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(v, 0));
        dis[v] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(cur.cost > dis[cur.vertex])
                continue;

            for(Edge o : graph.get(cur.vertex)){
                if(dis[o.vertex] > cur.cost + o.cost){
                    pq.add(new Edge(o.vertex, cur.cost + o.cost));
                    dis[o.vertex] = cur.cost + o.cost;
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int vertex, cost;
    public Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}