import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] tmp = new int[n];
        Arrays.fill(tmp, 1);
        for(int x : lost) tmp[x - 1]--;
        for(int x : reserve) tmp[x - 1]++;

        for(int i = 0; i < n; i++) {
            if(tmp[i] == 0) {
                if(i - 1 >= 0 && tmp[i - 1] > 1){
                    tmp[i - 1]--;
                    tmp[i]++;
                } else if(i + 1 < n && tmp[i + 1] > 1) {
                    tmp[i + 1]--;
                    tmp[i]++;
                }
            }
        }

        int answer = 0;
        for(int x : tmp) {
            if(x >= 1) answer++;
        }

        return answer;
    }
}