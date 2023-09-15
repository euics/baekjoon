import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = Integer.MIN_VALUE;
    static char[][] arr;
    static boolean[][] bool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++)
                arr[i][j] = input.charAt(j);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 'L')
                    solution(j, i);
            }
        }

        System.out.println(max);
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    private static void solution(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int[][] dis = new int[n][m];
        bool = new boolean[n][m];
        bool[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dix[i];
                int ny = cur[1] + diy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n && arr[ny][nx] == 'L'){
                    if(!bool[ny][nx]){
                        bool[ny][nx] = true;
                        dis[ny][nx] = dis[cur[1]][cur[0]] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        max = Math.max(max, findMax(dis));
    }

    private static int findMax(int[][] dis){
        int distance = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                distance = Math.max(distance, dis[i][j]);
        }

        return distance;
    }
}