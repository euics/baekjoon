import java.util.*;

class Solution {
    static int[] unf;
    static int[] groupSize;

    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < wires.length; i++){

            unf = new int[n + 1];
            groupSize = new int[n + 1];
            for(int j = 1; j <= n; j++){
                unf[j] = j;
                groupSize[j] = 1;
            }

            for(int j = 0; j < wires.length; j++){
                if(i == j) continue;

                union(wires[j][0], wires[j][1]);
            }

            minDiff = Math.min(minDiff, Math.abs(n - 2 * groupSize[find(1)]));
        }

        return minDiff;
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