import java.util.*;

class Solution {
    static ArrayList<ArrayList<Node>> graph;
    static int[] dis;
    
    public int solution(int n, int[][] edge) {
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<Node>());
        
        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(new Node(edge[i][1], 1));
            graph.get(edge[i][1]).add(new Node(edge[i][0], 1));
        }
        
        dijkstra(1);
        
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            if(max < dis[i] && dis[i] != Integer.MAX_VALUE)
                max = dis[i];
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(dis[i] == max) answer++;
        }
        
        return answer;
    }
    
    public void dijkstra(int v){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(v, 0));
        dis[v] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dis[cur.v] < cur.c) continue;
            
            for(Node o : graph.get(cur.v)){
                if(dis[o.v] > cur.c + o.c){
                    dis[o.v] = cur.c + o.c;
                    pq.add(new Node(o.v, cur.c + o.c));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int v, c;
    public Node(int v, int c){
        this.v = v;
        this.c = c;
    }
    
    @Override
    public int compareTo(Node o){
        return this.c - o.c;
    } 
}