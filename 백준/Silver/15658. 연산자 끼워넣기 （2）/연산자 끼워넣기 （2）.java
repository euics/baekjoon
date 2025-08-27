import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) cnt[i] = Integer.parseInt(st.nextToken());

        DFS(1, numbers, cnt, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void DFS(int L, int[] numbers, int[] cnt, int sum) {
        if (L == numbers.length) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        if (cnt[0] > 0) {
            cnt[0]--;
            DFS(L + 1, numbers, cnt, sum + numbers[L]);
            cnt[0]++;
        }
        if (cnt[1] > 0) {
            cnt[1]--;
            DFS(L + 1, numbers, cnt, sum - numbers[L]);
            cnt[1]++;
        }
        if (cnt[2] > 0) {
            cnt[2]--;
            DFS(L + 1, numbers, cnt, sum * numbers[L]);
            cnt[2]++;
        }
        if (cnt[3] > 0) {
            cnt[3]--;
            DFS(L + 1, numbers, cnt, sum / numbers[L]);
            cnt[3]++;
        }
    }
}