import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> cctvs = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvs.add(new int[]{j, i, map[i][j]});
                }
            }
        }

        DFS(0, map);
        System.out.println(answer);
    }

    static int[] dix = {1, 0, -1, 0}; // 우 하 좌 상
    static int[] diy = {0, 1, 0, -1};

    public static void DFS(int L, int[][] prevMap) {
        if(L == cctvs.size()){
            int cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(prevMap[i][j] == 0)
                        cnt++;
                }
            }
            answer = Math.min(answer, cnt);

            return;
        }

        int[] cur = cctvs.get(L);
        int x = cur[0];
        int y = cur[1];
        int type = cur[2];

        int[][] curMap = new int[N][M];
        for(int dir = 0; dir < 4; dir++){
            for(int i = 0; i < N; i++)
                curMap[i] = prevMap[i].clone();

            switch(type){
                case 1:
                    mark(x, y, dir, curMap);
                    break;
                case 2:
                    mark(x, y, dir, curMap);
                    mark(x, y, (dir + 2) % 4, curMap);
                    break;
                case 3:
                    mark(x, y, dir, curMap);
                    mark(x, y, (dir + 3) % 4, curMap);
                    break;
                case 4:
                    mark(x, y, dir, curMap);
                    mark(x, y, (dir + 2) % 4, curMap);
                    mark(x, y, (dir + 3) % 4, curMap);
                    break;
                case 5:
                    mark(x, y, dir, curMap);
                    mark(x, y, (dir + 1) % 4, curMap);
                    mark(x, y, (dir + 2) % 4, curMap);
                    mark(x, y, (dir + 3) % 4, curMap);
                    break;
            }

            DFS(L + 1, curMap);
        }
    }

    public static void mark(int x, int y, int dir, int[][] curMap){
        int nx = x + dix[dir];
        int ny = y + diy[dir];

        while (nx >= 0 && ny >= 0 && nx < M && ny < N) {
            if (curMap[ny][nx] == 6)
                break;
            if (curMap[ny][nx] == 0)
                curMap[ny][nx] = 7;
            nx += dix[dir];
            ny += diy[dir];
        }
    }
}