import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] durability, weight;
    static int maxBroken = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        durability = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(maxBroken);
    }

    public static void dfs(int idx, int brokenCount) {
        if (idx == N) {
            maxBroken = Math.max(maxBroken, brokenCount);
            return;
        }

        if (durability[idx] <= 0 || brokenCount == N - 1) { // If the current egg is already broken or all other eggs are broken
            dfs(idx + 1, brokenCount);
            return;
        }

        boolean isHit = false;
        for (int i = 0; i < N; i++) {
            if (i != idx && durability[i] > 0) {
                isHit = true;
                durability[idx] -= weight[i];
                durability[i] -= weight[idx];
                int tempBrokenCount = 0;
                if (durability[idx] <= 0) tempBrokenCount++;
                if (durability[i] <= 0) tempBrokenCount++;

                dfs(idx + 1, brokenCount + tempBrokenCount);

                // Backtracking
                durability[idx] += weight[i];
                durability[i] += weight[idx];
            }
        }

        if (!isHit) { // If the current egg didn't hit any other egg
            dfs(idx + 1, brokenCount);
        }
    }
}
