class Solution {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length; // 2
        int m = arr2[0].length; // 3
        int[][] answer = new int[n][m];

        for (int i = 0, idx = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2[0].length; j++){
                int sum = 0;
                for(int k = 0; k < arr1[0].length; k++){
                    sum += arr1[i][k] * arr2[k][j];
                }

                answer[i][idx++] = sum;
                if(idx >= m) idx = 0;
            }
        }

        return answer;
    }
}