import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r, c ,dir, cnt = 1;
    static int[][] arr;

    static int[] dix = {0, 1, 0, -1}; // 북 동 남 서
    static int[] diy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(c, r, dir);
        System.out.println(cnt);
    }

    private static void DFS(int x, int y, int direction){
        arr[y][x] = -1;

        for(int i = 0; i < 4; i++){
            direction = (direction + 3) % 4;

            int nx = x + dix[direction];
            int ny = y + diy[direction];
            if(nx >= 0 && ny >= 0 && nx < m && ny < n && arr[ny][nx] == 0){
                cnt++;
                DFS(nx, ny, direction);
                return;
            }
        }

        int back = (direction + 2) % 4;
        int bx = x + dix[back];
        int by = y + diy[back];
        if(bx >= 0 && by >= 0 && bx < m && by < n && arr[by][bx] != 1)
            DFS(bx, by, direction);
    }
}