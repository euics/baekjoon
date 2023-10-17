import java.io.*;
import java.util.*;

public class Main {
    static int v, e, k;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        dis = new int[v + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= v; i++)
            graph.add(new ArrayList<Edge>());

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken()))
                    .add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dijkstra();

        for(int i = 1; i <= v; i++){
            if(dis[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dis[i]);
        }
    }

    public static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));
        dis[k] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(dis[cur.v] < cur.c)
                continue;

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