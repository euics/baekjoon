import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r, answer = 0;
    static int[][] arr;
    static boolean[][] bool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true){
            bool = new boolean[n][n];
            boolean moved = false;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!bool[i][j])
                        moved = moved | findUnion(j, i);
                }
            }

            if(!moved)
                break;

            answer++;
        }

        System.out.println(answer);
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    private static boolean findUnion(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        ArrayList<int[]> union = new ArrayList<>();
        union.add(new int[]{x, y});
        bool[y][x] = true;
        int sum = arr[y][x];

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dix[i];
                int ny = cur[1] + diy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    int diff = Math.abs(arr[cur[1]][cur[0]] - arr[ny][nx]);
                    if(diff >= l && diff <= r){
                        if(!bool[ny][nx]){
                            bool[ny][nx] = true;
                            q.add(new int[]{nx, ny});
                            union.add(new int[]{nx, ny});
                            sum += arr[ny][nx];
                        }
                    }
                }
            }
        }

        if(union.size() > 1){
            int avg = sum / union.size();
            for(int[] pos : union)
                arr[pos[1]][pos[0]] = avg;

            return true;
        }

        return false;
    }
}