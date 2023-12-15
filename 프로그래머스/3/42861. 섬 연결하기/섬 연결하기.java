import java.util.*;

class Solution {
    static int[] unf, groupSize;
    public int solution(int n, int[][] costs) {
        unf = new int[n];
        groupSize = new int[n];

        for(int i = 0; i < n; i++){
            unf[i] = i;
            groupSize[i] = 1;
        }

        ArrayList<Edge> edge = new ArrayList<>();
        for(int i = 0; i < costs.length; i++) edge.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        Collections.sort(edge);

        int answer = 0;
        for(int i = 0; i < costs.length; i++){
            int fv1 = find(edge.get(i).v1);
            int fv2 = find(edge.get(i).v2);

            if(fv1 != fv2) {
                union(edge.get(i).v1, edge.get(i).v2);
                answer += edge.get(i).cost;
            }
        }

       return answer; 
    }

    public int find(int v){
        if(v == unf[v]) return unf[v];
        else return unf[v] = find(unf[v]);
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