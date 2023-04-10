import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        for(int x : arr)
            min = Math.min(min, x);

        boolean bool = false;
        for(int i = 1; i <= min; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[j] % i == 0)
                    bool = true;
                else {
                    bool = false;
                    break;
                }
            }

            if(bool)
                System.out.println(i);
        }
    }
}