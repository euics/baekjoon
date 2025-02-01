class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        
        for(String[] place : places) {
            boolean bool = false;
            
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(place[i].charAt(j) == 'P') {
                        if(isDistance(place, j, i)) {
                            bool = true;
                            break;
                        }
                    }
                }
                
                if(bool) {
                    break;
                }
            }
            
            answer[idx++] = bool ? 0 : 1;
        }
        
        return answer;
    }
    
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};
    
    static int[] dix2 = {0, 0, -2, 2, 1, 1, -1, 1};
    static int[] diy2 = {-2, 2, 0, 0, -1, 1, 1, -1};
    
    public boolean isDistance(String[] place, int x, int y) {
        // 멘하튼 거리 1
        for(int d = 0; d < 4; d++) {
            int nx = x + dix[d];
            int ny = y + diy[d];
            
            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                if(place[ny].charAt(nx) == 'P') {
                    return true;
                }
            }
        }
        
        // 멘하튼 거리 2
        for(int d = 0; d < 8; d++) {
            int nx = x + dix2[d];
            int ny = y + diy2[d];
            
            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                if(place[ny].charAt(nx) == 'P') {
                    if(d < 4) {
                        int midX = (x + nx) / 2;
                        int midY = (y + ny) / 2;
                        
                        if(place[midY].charAt(midX) != 'X') {
                            return true;
                        }
                    } else {
                        if(place[ny].charAt(x) != 'X' || place[y].charAt(nx) != 'X') {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}