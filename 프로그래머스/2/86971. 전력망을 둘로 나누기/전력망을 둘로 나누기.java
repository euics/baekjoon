import java.util.Arrays;

class Solution {
    static int[] unf;
    static int[] groupSize;

    public int solution(int n, int[][] wires) {
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < wires.length; i++) {

            unf = new int[n + 1];
            groupSize = new int[n + 1];
            init(n);

            for(int j = 0; j < wires.length; j++) {

                if(i == j) continue;

                union(wires[j][0], wires[j][1]);
            }

            diff = Math.min(diff, Math.abs(n - 2 * groupSize[find(1)]));

        }

        return diff;
    }

    private void init(int n) {
        Arrays.fill(groupSize, 1);
        for(int i = 1; i <= n; i++) unf[i] = i;
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