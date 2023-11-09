class Solution {
    static int answer = -1;
    
    public int solution(int N, int number) {
        DFS(N, number, 0, 0);
        
        return answer;
    }
    
    private void DFS(int N, int number, int cnt, int cur){
        if(cnt > 8){
            return;
        }
        
        if(cur == number){
            if(cnt < answer || answer == -1) {
                answer = cnt;
            }
            return;
        }
        
        int tmp = 0;
        for(int i = 1; i <= 8; i++){
            tmp = tmp * 10 + N;
            DFS(N, number, cnt + i, cur + tmp);
            DFS(N, number, cnt + i, cur - tmp);
            DFS(N, number, cnt + i, cur / tmp);
            DFS(N, number, cnt + i, cur * tmp);
        }
    }
}