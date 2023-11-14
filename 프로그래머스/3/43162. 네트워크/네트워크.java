class Solution {
    
    static int[] unf, groupNum;
    
    public int solution(int n, int[][] computers) {
        unf = new int[n + 1];
        groupNum = new int[n + 1];
        for(int i = 0; i < n; i++){
            unf[i] = i;
            groupNum[i] = 1;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1 && i != j){
                    int fa = find(i);
                    int fb = find(j);
                    
                    if(fa != fb){
                        union(fa, fb);
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(unf[i] == i){
                answer++;
            }
        }
        
        return answer;
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
            groupNum[fb] += groupNum[fa];
        }
    }
}