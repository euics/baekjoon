import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            if (K == 0) break;

            int[] lottoNumber = new int[K];
            int[] combination = new int[6];
            for (int i = 0; i < K; i++) lottoNumber[i] = Integer.parseInt(st.nextToken());
            combination(0, 0, lottoNumber, combination);
            System.out.println();
        }
    }

    public static void combination(int L, int s, int[] lottoNumber, int[] combination) {
        if (L == 6) {
            Arrays.sort(combination);
            for (int i = 0; i < 6; i++) System.out.printf("%d ", combination[i]);
            System.out.println();

            return;
        }

        for (int i = s; i < lottoNumber.length; i++) {
            combination[L] = lottoNumber[i];
            combination(L + 1, i + 1, lottoNumber, combination);
        }
    }
}