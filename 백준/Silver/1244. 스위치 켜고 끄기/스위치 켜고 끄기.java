import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken()) == 1;

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());

            if (input == 1) man(arr, order);
            else woman(arr, order);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i] ? 1 : 0);
            if (i % 20 == 0 || i == N) sb.append('\n');
            else sb.append(' ');
        }
        System.out.print(sb.toString());

    }

    public static void man(boolean[] arr, int idx) {
        for (int i = idx; i < arr.length; i += idx) arr[i] = !arr[i];
    }

    public static void woman(boolean[] arr, int idx) {
        int start = idx, end = idx;

        while (start - 1 >= 1 && end + 1 < arr.length && arr[start - 1] == arr[end + 1]) {
            start--;
            end++;
        }

        for (int i = start; i <= end; i++) arr[i] = !arr[i];
    }
}