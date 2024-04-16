class Solution {
    static int[] unf, groupSize;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++) {
            init(n);

            for(int j = 0; j < wires.length; j++) {
                if(i == j) continue;

                union(wires[j][0], wires[j][1]);
            }

            answer = Math.min(answer, Math.abs(n - 2 * groupSize[find(1)]));
        }
        
        return answer;
    }

    public void init(int n) {
        unf = new int[n + 1];
        groupSize = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            unf[i] = i;
            groupSize[i] = 1;
        }
    }

    public int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa != fb) {
            unf[fa] = fb;
            groupSize[fb] += groupSize[fa];
        }
    }
}