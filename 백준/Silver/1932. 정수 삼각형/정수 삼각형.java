import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][];
        for(int i = 0; i < n; i++) triangle[i] = new int[i + 1];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][];
        for(int i = 0; i < n; i++) dp[i] = new int[i + 1];
        dp[n - 1] = triangle[n - 1].clone();

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Math.max(triangle[i][j] + dp[i + 1][j], triangle[i][j] + dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}