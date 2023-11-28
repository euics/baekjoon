class Solution {
    public int solution(int N, int number) {
        DFS(N, number, 0, 0);
        return answer;
    }
    
    static int answer = -1;
    
    public void DFS(int N, int number, int L, int sum){
        if(L > 8){
            return;
        }
        
        if(sum == number) {
            if(L < answer || answer == -1) {
                answer = L;
            }
            
            return;
        }
        
        int tmp = 0;
        for(int i = 1; i <= 8; i++){
            tmp = tmp * 10 + N;
            DFS(N, number, L + i, sum + tmp);
            DFS(N, number, L + i, sum - tmp);
            DFS(N, number, L + i, sum / tmp);
            DFS(N, number, L + i, sum * tmp);
        }
    }
}