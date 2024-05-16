class Solution {
    static int[] unf, groupSize;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        init(n);
        for(int index = 0; index < n; index++) {
            for(int computer = 0; computer < n; computer++) {
                if(index == computer) continue;
                
                if(computers[index][computer] == 1) union(index, computer);
            }
        }
        
        for(int computer = 0; computer < n; computer++) {
            if(computer == find(computer)) answer++;
        }
        
        return answer;
    }
    
    public void init(int n) {
        unf = new int[n];
        groupSize = new int[n];
        for(int i = 0; i < n; i++) {
            unf[i] = i;
            groupSize[i] = 1;
        }
    }
    
    public int find(int v) {
        if(v == unf[v]) return unf[v];
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