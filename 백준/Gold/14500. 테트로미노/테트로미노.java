import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] bool;
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        bool = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bool[i][j] = true;
                solution(j, i, arr[i][j], 1);
                bool[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void solution(int x, int y, int sum, int cnt){
        bool[y][x] = true;

        if(cnt == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = x + dix[d];
            int ny = y + diy[d];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                if(!bool[ny][nx]){

                    if(cnt == 2){
                        bool[ny][nx] = true;
                        solution(x, y, sum + arr[ny][nx], cnt + 1);
                        bool[ny][nx] = false;
                    }

                    bool[ny][nx] = true;
                    solution(nx, ny, sum + arr[ny][nx], cnt + 1);
                    bool[ny][nx] = false;
                }
            }
        }
    }
}