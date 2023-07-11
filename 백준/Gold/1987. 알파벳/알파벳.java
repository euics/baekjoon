import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] arr;
    static boolean[][] bool;
    static int[] dix = {-1, 1, 0, 0};
    static int[] diy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static List<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        bool = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++)
                arr[i][j] = str.charAt(j);
        }

        list.add(arr[0][0]);
        DFS(0, 0, 1);

        System.out.println(max);
    }

    private static void DFS(int x, int y, int count){
        bool[x][y] = true;
        max = Math.max(max, count);

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(!list.contains(arr[nx][ny]) && !bool[nx][ny]) {
                    list.add(arr[nx][ny]);
                    DFS(nx, ny, count + 1);
                    list.remove((Character) arr[nx][ny]);
                }
            }
        }

        bool[x][y] = false;
    }
}