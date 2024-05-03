import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) triangle[i] = new int[i + 1];

        int row = 0, col = 0, num = 1, maxNum = n * (n + 1) / 2;
        int direction = 0;
        while (num <= maxNum) {
            triangle[row][col] = num++;

            switch (direction) {
                case 0:
                    if(row + 1 < n && triangle[row + 1][col] == 0) row++;
                    else {
                        col++;
                        direction = 1;
                    }
                    break;
                case 1:
                    if(col + 1 < n && triangle[row][col + 1] == 0) col++;
                    else {
                        row--;
                        col--;
                        direction = 2;
                    }
                    break;
                case 2:
                    if(row - 1 >= 0 && col - 1 >= 0 && triangle[row - 1][col - 1] == 0) {
                        row--;
                        col--;
                    } else {
                        row++;
                        direction = 0;
                    }
                    break;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                answer.add(triangle[i][j]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}