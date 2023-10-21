import java.io.*;
import java.util.*;

public class Main {
    static int n, b, c;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] -= b;
            sum++;
            if(arr[i] <= 0)
                arr[i] = 0;
        }

        for(int i = 0; i < n; i++){
            if(arr[i] != 0){
                if(arr[i] % c == 0)
                    sum += arr[i] / c;
                else
                    sum += (arr[i] / c + 1);
            }
        }

        System.out.println(sum);
    }
}