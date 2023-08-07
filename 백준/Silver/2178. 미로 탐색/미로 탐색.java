import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] dis;
    static boolean[][] bool;
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        bool = new boolean[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < m; j++)
                arr[i][j] = Character.getNumericValue(ch[j]);
        }

        BFS(0, 0);
        System.out.println(dis[n - 1][m - 1]);
    }

    private static void BFS(int x, int y){
        bool[y][x] = true;
        dis[y][x] = 1;  // 시작 위치의 거리를 1로 설정

        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(x, y));
        while(!q.isEmpty()){
            Coordinate tmp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dix[i];
                int ny = tmp.y + diy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(!bool[ny][nx] && arr[ny][nx] == 1){
                        bool[ny][nx] = true;
                        q.add(new Coordinate(nx, ny));
                        dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
                    }
                }
            }
        }
    }
}

class Coordinate {
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}