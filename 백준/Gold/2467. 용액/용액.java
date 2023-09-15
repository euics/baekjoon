import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        int p1 = 0, p2 = n - 1;
        long res1 = 0, res2 = 0;
        long min = Long.MAX_VALUE;
        while(p1 < p2){
            long curSum = arr[p1] + arr[p2];
            if(min > Math.abs(curSum)){
                min = Math.abs(curSum);
                res1 = arr[p1];
                res2 = arr[p2];
            }

            if(curSum > 0)
                p2--;
            else
                p1++;
        }

        System.out.printf("%d %d", res1, res2);
    }
}