import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
            Collections.sort(list, Collections.reverseOrder());
        }

        int rank = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > score) rank++;
            else if (list.get(i) == score) continue;
            else break;
        }

        if (list.size() == P && list.get(P - 1) >= score) System.out.println(-1);
        else System.out.println(rank);
    }
}