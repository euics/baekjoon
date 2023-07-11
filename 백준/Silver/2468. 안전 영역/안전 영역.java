import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] bool;
    static int[] dix = {-1, 1, 0, 0};
    static int[] diy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int k = 1; k <= 100; k++){
            bool = new boolean[n][n];
            count = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!bool[i][j] && arr[i][j] >= k){
                        DFS(i, j, k);
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    private static void DFS(int x, int y, int k){
        bool[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(arr[nx][ny] >= k && !bool[nx][ny])
                    DFS(nx, ny, k);
            }
        }
    }
}