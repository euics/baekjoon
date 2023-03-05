import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());

        int[][] arr = new int[101][101];
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++)
                arr[i][j] = 0;
        }

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int x = a; x < a + 10; x++){
                for(int y = b; y < b + 10; y++)
                    arr[x][y] = 1;
            }
        }

        int sum = 0;
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++)
                sum += arr[i][j];
        }

        System.out.println(sum);
    }
}