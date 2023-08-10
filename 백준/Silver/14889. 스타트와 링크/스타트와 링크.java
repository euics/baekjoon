import java.util.*;
import java.io.*;

public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] combination;
    static boolean[] bool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        bool = new boolean[n + 1];
        combination = new int[n / 2];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        Combination(0, 1);

        System.out.println(min);
    }

    private static void Combination(int L, int s){
        if(L == n / 2){
            int sum1 = 0;
            int sum2 = 0;

            for(int i = 0; i < n / 2; i++)
                bool[combination[i]] = true;

            int[] not_Combination = new int[n / 2];
            int index = 0;
            for(int i = 1; i <= n; i++){
                if(!bool[i])
                    not_Combination[index++] = i;
            }

            Arrays.fill(bool, false);

            for(int i = 0; i < n / 2 - 1; i++) { // 1
                for(int j = i + 1; j < n / 2; j++) { // 2
                    sum1 += arr[combination[i]][combination[j]] + arr[combination[j]][combination[i]];
                    sum2 += arr[not_Combination[i]][not_Combination[j]] + arr[not_Combination[j]][not_Combination[i]];
                }
            }

            min = Math.min(min, Math.abs(sum1 - sum2));

        } else{
            for(int i = s; i <= n; i++) {
                combination[L] = i;
                Combination(L + 1, i + 1);
            }
        }
    }
}