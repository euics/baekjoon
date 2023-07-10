import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int n, m;
    static boolean[] bool;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        bool = new boolean[n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        for(int i = 1; i <= n; i++){
            if(!bool[i]){
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void DFS(int index){
        if(bool[index])
            return;
        else{
            bool[index] = true;
            for(int i = 1; i <= n; i++){
                if(arr[index][i] == 1)
                    DFS(i);
            }
        }
    }
}

/*
 0 0 0 0 1
 0 0 0 0 0
 1 1 1 1 1
*/