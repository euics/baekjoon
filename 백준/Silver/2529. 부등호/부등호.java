import java.io.*;
import java.util.*;

public class Main {
    static String maxString = "", minString = "";
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] order = new char[k];
        for (int i = 0; i < k; i++) order[i] = st.nextToken().charAt(0);

        DFS(0, k, new int[k + 1], new boolean[10], order);

        System.out.println(maxString);
        System.out.println(minString);

//        char[] ch = new char[]{'<', '<', '<', '>', '<', '<', '>', '<', '>'};
//        int[] x = new int[]{5, 6, 8, 9, 0, 2, 3, 1, 7, 4};
//        System.out.println(accept(ch, x));
    }

    public static void DFS(int L, int N, int[] permutation, boolean[] bool, char[] order) {
        if (L == N + 1) {
            if (accept(order, permutation)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < permutation.length; i++) sb.append(permutation[i]);

                if (max < Long.parseLong(sb.toString())) {
                    max = Long.parseLong(sb.toString());
                    maxString = sb.toString();
                }
                if (min > Long.parseLong(sb.toString())) {
                    min = Long.parseLong(sb.toString());
                    minString = sb.toString();
                }
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!bool[i]) {
                bool[i] = true;
                permutation[L] = i;
                DFS(L + 1, N, permutation, bool, order);
                bool[i] = false;
            }
        }
    }

    public static boolean accept(char[] order, int[] permutation) {
        for (int i = 0; i < order.length; i++) {
            if (order[i] == '<') {
                if (permutation[i] >= permutation[i + 1]) return false;
            } else {
                if (permutation[i] <= permutation[i + 1]) return false;
            }
        }

        return true;
    }
}