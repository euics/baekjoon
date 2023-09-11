import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[101][101];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            ArrayList<Integer> directions = new ArrayList<>();
            directions.add(d);

            // 드래곤 커브 세대 계산
            for (int j = 0; j < g; j++) {
                for (int k = directions.size() - 1; k >= 0; k--) {
                    directions.add((directions.get(k) + 1) % 4);
                }
            }

            map[x][y] = 1;
            for (int dir : directions) {
                if (dir == 0) x++;
                else if (dir == 1) y--;
                else if (dir == 2) x--;
                else if (dir == 3) y++;
                
                if (x < 0 || x > 100 || y < 0 || y > 100) continue;
                map[x][y] = 1;
            }
        }

        // 1x1 사각형 찾기
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
