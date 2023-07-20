import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr, dis;
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};
    static Deque<Point> dq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    dq.addLast(new Point(i, j));
            }
        }

        BFS();

        boolean bool = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (arr[i][j] == 0) {
                    bool = false;
                    break;
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        if(bool){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else
            System.out.println(-1);
    }

    private static void BFS(){
        while(!dq.isEmpty()){
            Point tmp = dq.pollFirst();
            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dix[i];
                int ny = tmp.y + diy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(arr[ny][nx] == 0){
                        arr[ny][nx] = 1;
                        dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
                        dq.addLast(new Point(ny, nx));
                    }
                }
            }
        }
    }
}

class Point{
    int x, y;
    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}