import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] bool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        bool = new boolean[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);

        System.out.println(minDiff);
    }

    private static void combination(int L, int s){
        if(L == n / 2){
            calculateDiff();
            return;
        } else{
            for(int i = s; i < n; i++){
                bool[i] = true;
                combination(L + 1, i + 1);
                bool[i] = false;
            }
        }
    }

    static int minDiff = Integer.MAX_VALUE;

    private static void calculateDiff(){
        int start = 0;
        int link = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i == j)
                    continue;

                if(bool[i] && bool[j]){
                    start += arr[i][j];
                    start += arr[j][i];
                } else if(!bool[i] && !bool[j]){
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        minDiff = Math.min(minDiff, Math.abs(start - link));
    }
}