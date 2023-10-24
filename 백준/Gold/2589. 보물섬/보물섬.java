import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = Integer.MIN_VALUE;
    static char[][] arr;
    static int[][] dis;
    static boolean[][] bool;

    public static void main(String[] args) throws IOException{
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
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'L'){
                    bool = new boolean[n][m];
                    dis = new int[n][m];

                    solution(j, i);

                    max = Math.max(max, findMinTime());
                }
            }
        }

        System.out.println(max);
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public static void solution(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        bool[y][x] = true;
        int L = 0;

        while(!q.isEmpty()){
            int length = q.size();

            for(int i = 0; i < length; i++){
                int[] cur = q.poll();

                for(int d = 0; d < 4; d++){
                    int nx = cur[0] + dix[d];
                    int ny = cur[1] + diy[d];

                    if(nx >= 0 && ny >= 0 && nx < m && ny < n && arr[ny][nx] == 'L'){
                        if(!bool[ny][nx]){
                            bool[ny][nx] = true;
                            q.add(new int[]{nx, ny});
                            dis[ny][nx] = dis[cur[1]][cur[0]] + 1;
                        }
                    }
                }
            }
        }
    }

    public static int findMinTime(){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'L' && dis[i][j] != 0){
                    if(max < dis[i][j])
                        max = dis[i][j];
                }
            }
        }

        return max;
    }
}