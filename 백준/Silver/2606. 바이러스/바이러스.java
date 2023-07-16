import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] bool;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        bool = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 2; j++)
                arr[a][b] = arr[b][a] = 1;
        }

        DFS(1);

        System.out.println(count);
    }

    private static void DFS(int node){
        bool[node] = true;

        for(int i = 1; i <= n; i++){
            if(arr[node][i] == 1 && !bool[i]){
                count++;
                DFS(i);
            }
        }
    }
}