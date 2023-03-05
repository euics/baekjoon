import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long result = 0;
        long max = 0;

        long [] arr= new long[K];
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long min = 1;
        while(min <= max){
            long half = (min + max) / 2;
            long cnt = 0;

            for(long x : arr)
                cnt += x / half;

            if(cnt < N)
                max = half - 1;
            else
                min = half + 1;
        }

        result = (min + max) / 2;

        System.out.println(result);
        br.close();
    }
}
