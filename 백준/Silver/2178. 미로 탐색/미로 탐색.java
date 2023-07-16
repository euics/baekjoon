import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int N, M;

    // 상하좌우 이동을 위한 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        visited = new boolean[N][M];

        sc.nextLine(); // 버퍼를 비워주는 역할

        for(int i = 0; i < N; i++){
            String str = sc.nextLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j) - '0';
                visited[i][j] = false;
            }
        }

        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<Position>();
        queue.offer(new Position(x, y));

        while(!queue.isEmpty()) {
            Position pos = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                // 미로 범위를 벗어나면 무시
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽이거나, 이미 방문한 곳이면 무시
                if(arr[nx][ny] == 0 || visited[nx][ny]) continue;

                // 최소 칸 수를 증가시킴
                arr[nx][ny] = arr[pos.x][pos.y] + 1;
                visited[nx][ny] = true;
                queue.offer(new Position(nx, ny));
            }
        }
    }
}
