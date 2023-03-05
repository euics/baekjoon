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
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0, end = n - 1, answer = 0;
        while(start < end){
            int sum = arr[start] + arr[end];

            if(sum == m){
                answer++;
                start++;
                end--;
            } else if(sum > m)
                end--;
            else
                start++;
        }

        System.out.println(answer);
    }
}