import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n + 1];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while(start <= n && end <= n){

            if(sum >= s){
                sum -= arr[start++];
                min = Math.min(min, end - start + 1);
            } else
                sum += arr[end++];
        }

        if(min == Integer.MAX_VALUE)
            System.out.println("0");
        else
            System.out.println(min);
    }
}