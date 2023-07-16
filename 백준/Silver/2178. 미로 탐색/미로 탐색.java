import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] bool;

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0,};
    static class Position{
        int x, y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        bool = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++)
                arr[i][j] = Character.getNumericValue(input.charAt(j));
        }

        BFS(0, 0);
        System.out.println(arr[n - 1][m - 1]);
    }

    private static void BFS(int y, int x){
        Deque<Position> deque = new LinkedList<Position>();
        deque.addLast(new Position(x, y));

        while(!deque.isEmpty()){
            Position cur = deque.pollFirst();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dix[i];
                int ny = cur.y + diy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(arr[ny][nx] == 1 && !bool[ny][nx]){
                        arr[ny][nx] = arr[cur.y][cur.x] + 1;
                        bool[ny][nx] = true;
                        deque.addLast(new Position(nx, ny));
                    }
                }
            }
        }
    }
}