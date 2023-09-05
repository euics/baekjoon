import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, area = 0, cnt = 1;
    static int[][] arr;
    static boolean[][] bool;
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};
    static ArrayList<Integer> total = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        bool = new boolean[m][n];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = m - Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = m - Integer.parseInt(st.nextToken());

            for(int diy = y2; diy <= y1; diy++){
                for(int dix = x1; dix <= x2; dix++){
                    arr[diy][dix] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!bool[i][j] && arr[i][j] == 0){
                    cnt = 1;
                    area++;
                    DFS(j, i);
                    total.add(cnt);
                }
            }
        }

        Collections.sort(total);

        System.out.println(area);
        for(int x : total)
            System.out.printf("%d ", x);
    }

    private static void DFS(int x, int y){
        bool[y][x] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[ny][nx] == 0){
                if(!bool[ny][nx]){
                    cnt++;
                    DFS(nx, ny);
                }
            }
        }
    }
}