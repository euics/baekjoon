import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            int[] arr = new int[20];
            for (int j = 0; j < 20; j++) arr[j] = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int j = 1; j < 20; j++) {
                if (arr[j - 1] > arr[j]) {
                    int idx = -1;

                    for (int l = 0; l < j; l++) {
                        if (arr[l] > arr[j]) {
                            idx = l;
                            break;
                        }
                    }

                    cnt += move(arr, idx, j);
                }
            }

            sb.append(T).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int move(int[] arr, int start, int end) {
        int tmp = arr[end];
        for (int i = end; i > start; i--) arr[i] = arr[i - 1];
        arr[start] = tmp;

        return end - start;
    }
}
