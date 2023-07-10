import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] bool;
    static int[] dix = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] diy = {0, 0, -1, 1, -1, 1, 1, -1};
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0)
                break;

            arr = new int[b][a];
            bool = new boolean[b][a];
            for(int i = 0; i < b; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < a; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for(int i = 0; i < b; i++){
                for(int j = 0; j < a; j++){
                    if(!bool[i][j] && arr[i][j] == 1) {
                        DFS(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void DFS(int x, int y){
        bool[x][y] = true;

        for(int i = 0; i < 8; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < b && ny < a){
                if(arr[nx][ny] == 1 && !bool[nx][ny])
                    DFS(nx, ny);
            }
        }
    }
}