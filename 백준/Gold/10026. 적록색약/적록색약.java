import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] normal;
    static char[][] blind;
    static boolean[][] bool;
    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        normal = new char[n][n];
        blind = new char[n][n];
        bool = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            char[] ch = tmp.toCharArray();
            for(int j = 0; j < n; j++){
                normal[i][j] = ch[j];

                if(ch[j] == 'G')
                    blind[i][j] = 'R';
                else
                    blind[i][j] = ch[j];
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!bool[i][j]) {
                    answer++;
                    normal_DFS(j, i);
                }
            }
        }

        System.out.printf("%d ", answer);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                bool[i][j] = false;
        }

        answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!bool[i][j]){
                    answer++;
                    blind_DFS(j, i);
                }
            }
        }

        System.out.println(answer);
    }

    private static void normal_DFS(int x, int y){
        bool[y][x] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(!bool[ny][nx] && normal[ny][nx] == normal[y][x])
                    normal_DFS(nx, ny);
            }
        }
    }

    private static void blind_DFS(int x, int y){
        bool[y][x] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(!bool[ny][nx] && blind[ny][nx] == blind[y][x])
                    blind_DFS(nx, ny);
            }
        }
    }

}