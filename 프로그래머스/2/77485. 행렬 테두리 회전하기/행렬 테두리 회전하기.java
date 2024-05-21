class Solution {
    static int[][] arr;
    static int[] result;

    public int[] solution(int rows, int columns, int[][] queries) {
        init(rows, columns, queries);
        for(int index = 0; index < queries.length; index++) rotate(queries[index], index);

        return result;
    }

    public void init(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        result = new int[queries.length];

        int index = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = index++;
            }
        }
    }

    public void print(int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public void rotate(int[] query, int index) {
        int row1 = query[0] - 1; // 1
        int col1 = query[1] - 1; // 1
        int row2 = query[2] - 1; // 4
        int col2 = query[3] - 1; // 3

        int firstNum = arr[row1][col2];
        int min = Integer.MAX_VALUE;

        // 상단 rotate
        for(int col = col2; col > col1; col--) {
            min = Math.min(min, arr[row1][col]);
            arr[row1][col] = arr[row1][col - 1];
        }

        // 좌측 rotate
        for(int row = row1; row < row2; row++) {
            min = Math.min(min, arr[row][col1]);
            arr[row][col1] = arr[row + 1][col1];
        }

        // 하단 rotate
        for(int col = col1; col < col2; col++) {
            min = Math.min(min, arr[row2][col]);
            arr[row2][col] = arr[row2][col + 1];
        }

        // 오른쪽 rotate
        for(int row = row2; row > row1; row--) {
            min = Math.min(min, arr[row][col2]);
            arr[row][col2] = arr[row - 1][col2];
        }

        // 마지막 회전 후 숫자 대입
        arr[row1 + 1][col2] = firstNum;
        result[index] = min;
    }
}