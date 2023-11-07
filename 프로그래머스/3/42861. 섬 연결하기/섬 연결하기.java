import java.util.*;

class Solution {
    static int[] unf;
    static int[] groupSize;
    
    public int solution(int n, int[][] costs) {
        unf = new int[n + 1];
        groupSize = new int[n + 1];
        for(int i = 1; i <= n; i++){
            unf[i] = i;
            groupSize[i] = 1;
        }
        
        List<Edge> graph = new ArrayList<>();
        for(int i = 0; i < costs.length; i++){
            graph.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        Collections.sort(graph);
        
        int answer = 0;
        for(Edge o : graph){
            int fa = find(o.v1);
            int fb = find(o.v2);
            
            if(fa != fb){
                answer += o.cost;
                union(o.v1, o.v2);
            }
        }
        
        return answer;
    }
    
    public int find(int v){
        if(v == unf[v])
            return unf[v];
        else
            return unf[v] = find(unf[v]);
    }
    
    public void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb){
            unf[fa] = fb;
            groupSize[fb] += groupSize[fa];
        }
    }
}

class Edge implements Comparable<Edge>{
    int v1, v2, cost;
    public Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}