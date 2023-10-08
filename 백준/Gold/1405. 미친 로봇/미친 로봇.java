import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] bool = new boolean[30][30];
    static double[] percent = new double[4];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 4; i++)
            percent[i] = Integer.parseInt(st.nextToken()) * 0.01;

        solution(15, 15, 0, 1);

        System.out.println(result);
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};
    static double result = 0;

    private static void solution(int x, int y, int cnt, double total){
        bool[y][x] = true;

        if(cnt == n){
            result += total;
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dix[i];
            int ny = y + diy[i];

            if(nx >= 0 && ny >= 0 && nx < 30 && ny < 30){
                if(!bool[ny][nx]){
                    bool[ny][nx] = true;
                    solution(nx, ny, cnt + 1, total * percent[i]);
                    bool[ny][nx] = false;
                }
            }
        }
    }
}