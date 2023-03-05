import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            while(from <= to){
                arr[from] = ball;
                from++;
            }

        }

        for(int i = 1; i <= n; i++)
            System.out.printf("%d ", arr[i]);
    }
}