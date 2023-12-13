import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for(int i = 0; i < lost.length; i++) arr[lost[i] - 1]--;
        for(int i = 0; i < reserve.length; i++) arr[reserve[i] - 1]++;

        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                if(i - 1 >= 0 && arr[i - 1] > 1){
                    arr[i]++;
                    arr[i - 1]--;
                } else if(i + 1 < n && arr[i + 1] > 1){
                    arr[i]++;
                    arr[i + 1]--;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] >= 1) answer++;
        }

        return answer;
    }
}