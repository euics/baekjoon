import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dix = {0, -1, 0, 1};
    static int[] diy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        int[] cur = null;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    cur = new int[]{i, j};
                    arr[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0; // 먹은 물고기 수
        int move = 0; // 움직인 총 거리

        while(true){
            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->
                        o1[2] != o2[2] ? o1[2] - o2[2] : (o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1])
                    );
            boolean[][] visit = new boolean[n][n];

            q.add(new int[]{cur[0], cur[1], 0}); // y좌표, x좌표, 이동한 거리
            visit[cur[0]][cur[1]] = true;

            boolean ck = false; // 상어가 먹이를 먹었는지 체크할 변수

            while(!q.isEmpty()){
                cur = q.poll();

                if(arr[cur[0]][cur[1]] != 0 && arr[cur[0]][cur[1]] < size) { // 먹이가 있으면서 상어의 사이즈보다 작다면?
                    arr[cur[0]][cur[1]] = 0; // 물고기 제거
                    eat++;
                    move += cur[2]; // 움직인 거리를 총 움직인 거리에 추가
                    ck = true; // 먹이 먹었다고 체크
                    break;
                }

                for(int d = 0; d < 4; d++){
                    int nx = cur[1] + dix[d];
                    int ny = cur[0] + diy[d];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n || visit[ny][nx] || arr[ny][nx] > size)
                        continue;

                    q.add(new int[]{ny, nx, cur[2] + 1});
                    visit[ny][nx] = true;
                }
            }

            if (!ck) // 큐가 비워질 때까지 먹이를 먹은적이 없다면, 더 이상 먹은 물고기가 없으므로 탈출
                break;

            if (size == eat) { // 사이즈와 먹이를 먹은 수가 동일하다면 상어의 크기를 증가
                size++;
                eat = 0;
            }
        }

        System.out.println(move);
    }
}