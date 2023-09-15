import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for(int i = 0; i < r; i++){
            String input = br.readLine();
            for(int j = 0; j < c; j++)
                arr[i][j] = input.charAt(j);
        }

        solution();

        System.out.println(1);
        for(char[] a : arr){
            for(char b : a)
                System.out.printf("%c", b);
            System.out.println();
        }
    }

    static int[] dix = {0, 0, -1, 1};
    static int[] diy = {-1, 1, 0, 0};

    private static void solution(){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(arr[i][j] == 'W')
                    q.add(new int[]{j, i});
            }
        }

        while(!q.isEmpty()){
            int[] curWolf = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = curWolf[0] + dix[i];
                int ny = curWolf[1] + diy[i];

                if(nx >= 0 && ny >= 0 && nx < c && ny < r){
                    if(arr[ny][nx] == 'S'){
                        System.out.println(0);
                        System.exit(0);
                    }

                    if(arr[ny][nx] == '.')
                        arr[ny][nx] = 'D';
                }
            }
        }
    }
}