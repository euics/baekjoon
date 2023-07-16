import java.util.*;
import java.io.*;

public class Main {
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    static int[][] arr;
    static boolean[][] bool;

    static int n, count = 0;

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
        for(int i = 1; i <= 100; i++){
            bool = new boolean[n][n];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(arr[j][k] >= i && !bool[j][k]){
                        count++;
                        DFS(j, k, i);
                    }
                }
            }
            max = Math.max(max, count);
            count = 0;
        }

        System.out.println(max);
    }

    private static void DFS(int y, int x, int height){
        bool[y][x] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(arr[ny][nx] >= height && !bool[ny][nx])
                    DFS(ny, nx, height);
            }
        }
    }
}