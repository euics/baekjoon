import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < str.length; i++)
            arr[i] = Integer.parseInt(str[i]);

        Arrays.sort(arr);

        int start = 0, end = n - 1;
        int min = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0;

        while(start < end){
            int sum = arr[start] + arr[end];

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                answer1 = arr[start];
                answer2 = arr[end];
            }

            if(sum > 0) end--;
            else start++;
        }

        System.out.printf("%d %d", answer1, answer2);
    }
}
/*

-99 -2 -1 4 98

 */