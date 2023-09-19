import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long[] answer = new long[2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        int left = 0, right = n - 1;
        long min = Long.MAX_VALUE;
        while(left < right){
            long sum = arr[left] + arr[right];

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if(sum > 0)
                right--;
            else
                left++;
        }

        System.out.printf("%d %d", answer[0], answer[1]);
    }
}