class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        quad(arr, arr.length, 0, 0);
        
        return answer;
    }
    
    public void quad(int[][] arr, int compress, int x, int y) {
        if(canQuad(arr, compress, arr[y][x], x, y)) {
            if(arr[y][x] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
            
            return;
        }
        
        quad(arr, compress / 2, x, y);
        quad(arr, compress / 2, x + compress / 2, y);
        quad(arr, compress / 2, x, y + compress / 2);
        quad(arr, compress / 2, x + compress / 2, y + compress / 2);
    }
    
    public boolean canQuad(int[][] arr, int compress, int val, int x, int y) {
        for(int ny = y; ny < y + compress; ny++) {
            for(int nx = x; nx < x + compress; nx++) {
                if(arr[ny][nx] != val) {
                    return false;
                }
            }
        }
        
        return true;
    }
}