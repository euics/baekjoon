import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] t, p, dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];

        for(int i = 0; i < n; i++){
            if(i + t[i] <= n)
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}