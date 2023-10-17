import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};
    static boolean[][] bool;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        bool = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++)
                arr[i][j] = line.charAt(j) - '0';
        }

        System.out.println(BFS());
    }

    public static int BFS(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        bool[0][0] = true;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(cur[0] == m - 1 && cur[1] == n - 1)
                return cur[2];

            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dix[d];
                int ny = cur[1] + diy[d];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(!bool[ny][nx]){
                        bool[ny][nx] = true;
                        pq.add(new int[]{nx, ny, cur[2] + arr[ny][nx]});
                    }
                }
            }
        }

        return 0;
    }
}