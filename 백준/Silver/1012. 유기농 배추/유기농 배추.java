import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] bool;
    static int count = 0;
    static int[] dix = {-1, 1, 0, 0};
    static int[] diy = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            bool = new boolean[n][m];

            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            for(int l = 0; l < n; l++){
                for(int j = 0; j < m; j++){
                    if(arr[l][j] == 1 && !bool[l][j]){
                        DFS(l, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;
        }
    }

    private static void DFS(int x, int y){
        bool[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(arr[nx][ny] == 1 && !bool[nx][ny])
                    DFS(nx, ny);
            }
        }
    }
}

/*
 0 0 0 0 1
 0 0 0 0 0
 1 1 1 1 1
*/