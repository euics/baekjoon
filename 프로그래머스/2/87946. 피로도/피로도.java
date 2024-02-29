class Solution {
    static boolean[] bool;
    static int[] permutation;

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        permutation = new int[n];
        bool = new boolean[n];

        permutation(0, n, k, dungeons);

        return max;
    }

    private void permutation(int L, int n, int k, int[][] dungeons) {
        if(L == n) {
            explore(k, dungeons);

            return;
        }

        for(int i = 0; i < n; i++) {
            if(!bool[i]) {
                bool[i] = true;
                permutation[L] = i;
                permutation(L + 1, n, k, dungeons);
                bool[i] = false;
            }
        }
    }

    static int max = Integer.MIN_VALUE;

    private void explore(int k, int[][] dungeons) {
        int tmp = k, cnt = 0;

        for(int index : permutation) {

            if(tmp < dungeons[index][0]) break;

            tmp -= dungeons[index][1];
            cnt++;

        }

        max = Math.max(max, cnt);
    }
}