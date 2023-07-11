import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, cnt1 = 0, cnt2 = 0;
    static int[][] arr;
    static boolean[][] bool;
    static int[] dix = {-1, 1, 0, 0};
    static int[] diy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        bool = new boolean[m][n];
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int a = y1; a < y2; a++){
                for(int b = x1; b < x2; b++)
                    arr[a][b] = 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!bool[i][j] && arr[i][j] == 0){
                    cnt2 = 0;
                    DFS(i, j);
                    list.add(cnt2);
                    cnt1++;
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt1);
        for(int x : list)
            System.out.printf("%d ", x);
    }

    private static void DFS(int x, int y){
        bool[x][y] = true;
        cnt2++;

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >=0 && nx < m && ny < n){
                if(arr[nx][ny] == 0 && !bool[nx][ny])
                    DFS(nx, ny);
            }
        }
    }
}