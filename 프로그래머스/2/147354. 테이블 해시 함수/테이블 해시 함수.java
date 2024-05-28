import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 주어진 조건에 따라 테이블 정렬
        Arrays.sort(data, (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]);

        int answer = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int Si = 0;
            for (int j = 0; j < data[i].length; j++) {
                Si += data[i][j] % (i + 1);
            }
            answer ^= Si;  // 각 S_i 값을 XOR 연산
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{ {2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3} }, 2, 2, 3)); // 예시 인자값을 넣어 호출
    }
}
