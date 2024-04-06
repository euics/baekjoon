class Solution {
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return answer;
    }
    
    static int[] answer = new int[2];
    
    public void quad(int[][] arr, int x, int y, int size) {
        if(zip(arr, x, y, size, arr[y][x])) {
            if(arr[y][x] == 1) answer[1]++;
            else answer[0]++;
            
            return;
        }
        
        quad(arr, x, y, size / 2);
        quad(arr, x, y + size / 2, size / 2);
        quad(arr, x + size / 2, y, size / 2);
        quad(arr, x + size / 2, y + size / 2, size / 2);
    }

    public boolean zip(int[][] arr, int x, int y, int size, int val) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != val) return false;
            }
        }

        return true;
    }
}