import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static int[] unf;
    static int[] groupSize;

    public int solution(int n, int[][] costs) {
        unf = new int[n];
        groupSize = new int[n];
        for(int i = 0; i < n; i++) {
            unf[i] = i;
            groupSize[i] = 1;
        }

        List<Edge> edge = new ArrayList<>();
        for(int[] cost : costs) edge.add(new Edge(cost[0], cost[1], cost[2]));
        Collections.sort(edge);
        
        int answer = 0;
        for(Edge o : edge) {
            int fv1 = find(o.v1);
            int fv2 = find(o.v2);
            
            if(fv1 != fv2) {
                union(o.v1, o.v2);
                answer += o.cost;
            }
        }
        
        return answer;
    }

    private int find(int v) {
        if(v == unf[v]) return unf[v];
        else return unf[v] = find(unf[v]);
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa != fb) {
            unf[fa] = fb;
            groupSize[fb] += groupSize[fa];
        }
    }
}

class Edge implements Comparable<Edge> {
    int v1, v2, cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}