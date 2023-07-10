import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] arr;
    static boolean[][] bool;
    static int count = 0;
    static int[] dix = {-1, 1, 0, 0};
    static int[] diy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        bool = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++)
                arr[i][j] = str.charAt(j);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!bool[i][j]){
                    DFS(i, j);
                    count++;
                }
            }
        }

        int normal = count;
        count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 'G')
                    arr[i][j] = 'R';
            }
        }

        bool = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!bool[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }

        int addNormal = count;
        System.out.printf("%d %d", normal, addNormal);
    }

    private static void DFS(int x, int y){
        bool[x][y] = true;
        char color = arr[x][y];

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(arr[nx][ny] == color && !bool[nx][ny])
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