import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[] bool;
    static int answer = 0;

    private static int DFS(int start){
        bool[start] = true;
        for(int i = 1; i <= n; i++){
            if(arr[start][i] == 1 && !bool[i]) {
                answer++;
                DFS(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        bool = new boolean[n + 1];
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        DFS(1);
        System.out.println(answer);
    }
}
