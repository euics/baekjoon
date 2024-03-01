import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for(int x : lost) arr[x - 1]--;
        for(int x : reserve) arr[x - 1]++;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                if(i - 1 >= 0 && arr[i - 1] == 2) {
                    arr[i - 1]--;
                    arr[i]++;
                } else if(i + 1 < n && arr[i + 1] == 2) {
                    arr[i + 1]--;
                    arr[i]++;
                }
            }
        }

        int cnt = 0;
        for(int x : arr) {
            if(x >= 1) cnt++;
        }

        return cnt;
        // 2 0 2 0 2
    }
}