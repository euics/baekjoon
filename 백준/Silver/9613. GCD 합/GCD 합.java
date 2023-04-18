import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[m];
            long cnt = 0;
            for(int j = 0; j < m; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            for(int j = 0; j < arr.length; j++){
                BigInteger a = new BigInteger(String.valueOf(arr[j]));
                for(int k = j + 1; k < arr.length; k++){
                    BigInteger b = new BigInteger(String.valueOf(arr[k]));

                    cnt += a.gcd(b).longValue();
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}