class Solution {
    static int[] unf, groupSize;
    
    public int solution(int n, int[][] computers) {
        unf = new int[n];
        groupSize = new int[n];
        for(int i = 0; i < n; i++){
            unf[i] = i;
            groupSize[i] = 1;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(unf[i] == i) answer++;
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
            groupSize[fb] += groupSize[fa];
        }
    }
}