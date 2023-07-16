import java.util.*;
import java.io.*;

public class Main {
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    static int[][] arr;
    static boolean[] bool;

    static int m, n, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        bool = new boolean[n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        for(int i = 1; i <= n; i++){
            if(!bool[i]){
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void DFS(int node){
        bool[node] = true;

        for(int i = 1; i <= n; i++){
            if(arr[node][i] == 1 && !bool[i])
                DFS(i);
        }
    }
}