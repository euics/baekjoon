import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tmp = new int[n][m];
        tmp[0][0] = arr[0][0];
        for(int i = 1; i < n; i++) tmp[i][0] = tmp[i - 1][0] + arr[i][0];
        for(int j = 1; j < m; j++) tmp[0][j] = tmp[0][j - 1] + arr[0][j];

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                tmp[i][j] = Math.max(Math.max(tmp[i - 1][j], tmp[i][j - 1]), tmp[i - 1][j - 1]) + arr[i][j];
            }
        }

        System.out.println(tmp[n - 1][m - 1]);
    }
}