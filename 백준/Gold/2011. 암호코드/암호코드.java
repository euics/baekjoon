import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] code = br.readLine().toCharArray();
        int mod = 1000000;

        if(code[0] == '0'){
            System.out.println(0);
            return;
        }

        int[] dp = new int[code.length + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= code.length; i++){
            int cur = code[i - 1] - '0';
            int prev = code[i - 2] - '0';

            if(cur >= 1 && cur <= 9)
                dp[i] = (dp[i] + dp[i - 1]) % mod;

            int combine = prev * 10 + cur;
            if(combine >= 10 && combine <= 26)
                dp[i] = (dp[i] + dp[i - 2]) % mod;
        }

        System.out.println(dp[code.length]);
    }
}