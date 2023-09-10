import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y, k;
    static int[][] arr;
    static int[] dix = {0, 1, -1, 0, 0};
    static int[] diy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Dice curDice = new Dice(0, 0, 0, 0, 0, 0);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            int a = Integer.parseInt(st.nextToken());

            int nx = x + dix[a];
            int ny = y + diy[a];
            if(nx < 0 || ny < 0 || nx >= m || ny >= n)
                continue;

            Dice newDice = null;
            if(a == 1)
                newDice = new Dice(curDice.left, curDice.up, curDice.down, curDice.bottom, curDice.top, curDice.right);
            else if(a == 2)
                newDice = new Dice(curDice.right, curDice.up, curDice.down, curDice.top, curDice.bottom, curDice.left);
            else if(a == 3)
                newDice = new Dice(curDice.up, curDice.bottom, curDice.top, curDice.left, curDice.right, curDice.down);
            else if(a == 4)
                newDice = new Dice(curDice.down, curDice.top, curDice.bottom, curDice.left, curDice.right, curDice.up);

            curDice = newDice;
            x = nx;
            y = ny;

            if(arr[y][x] == 0){
                arr[y][x] = curDice.bottom;
                System.out.println(curDice.top);
            } else{
                curDice.bottom = arr[y][x];
                arr[y][x] = 0;
                System.out.println(curDice.top);
            }
        }
    }
}

class Dice {
    int top, up, down, left, right, bottom;
    public Dice(int top, int up, int down, int left, int right, int bottom){
        this.top = top;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }
}