import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix1 = new int[n][m];
        int[][] matrix2 = new int[n][m];

        int content = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                content = sc.nextInt();
                matrix1[i][j] = content;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                content = sc.nextInt();
                matrix2[i][j] = content;
            }
        }

        int[][] result = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                result[i][j] = matrix1[i][j] + matrix2[i][j];
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                System.out.printf("%d ", result[i][j]);
            System.out.println();
        }
    }
}

/*
97 122
*/