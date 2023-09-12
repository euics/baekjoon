import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y, k;
    static int[][] arr;
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x =Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dice = new int[]{0, 0, 0, 0, 0, 0};

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++)
            solution(Integer.parseInt(st.nextToken()));
    }

    static int[] dix = {0, 1, -1, 0, 0}; // 0, 동 서 북 남
    static int[] diy = {0, 0, 0, -1, 1};

    private static void solution(int k){
        int a = dice[0];
        int b = dice[1];
        int c = dice[2];
        int d = dice[3];
        int e = dice[4];
        int f = dice[5];

        int nx = x + dix[k];
        int ny = y + diy[k];
        if(nx < 0 || ny < 0 || nx >= m || ny >= n)
            return;

        if(k == 1){
            dice[1] = e; // Top -> Left
            dice[3] = f; // Bottom -> Right
            dice[4] = d; // Left -> Bottom
            dice[5] = b; // Right -> Top
        }
        else if(k == 2){
            dice[1] = f; // Top -> Right
            dice[3] = e; // Bottom -> Left
            dice[4] = b; // Left -> Top
            dice[5] = d; // Right -> Bottom
        }
        else if(k == 3){
            dice[0] = b; // Up -> Top
            dice[1] = c; // Top -> Down
            dice[2] = d; // Down -> Bottom
            dice[3] = a; // Bottom -> Up
        }
        else if(k == 4){
            dice[0] = d; // Up -> Bottom
            dice[1] = a; // Top -> Up
            dice[2] = b; // Down -> Top
            dice[3] = c; // Bottom -> Down
        }

        if(arr[ny][nx] == 0)
            arr[ny][nx] = dice[3];
        else {
            dice[3] = arr[ny][nx];
            arr[ny][nx] = 0;
        }

        x = nx;
        y = ny;

        System.out.println(dice[1]);
    }
}