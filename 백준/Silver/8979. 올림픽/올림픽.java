import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Info> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] ranks = new int[N + 1];
        int rank = 1;
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            ranks[cur.idx] = rank;

            int[] a = new int[]{cur.g, cur.s, cur.b};
            int cnt = 1;
            while (!pq.isEmpty()) {
                int[] b = new int[]{pq.peek().g, pq.peek().s, pq.peek().b};
                if (!Arrays.equals(a, b)) break;
                else ranks[pq.poll().idx] = rank;
                cnt++;
            }

            rank += cnt;
        }

        System.out.println(ranks[K]);
    }

    public static boolean equals(Info a, Info b) {
        return a.g == b.g && a.s == b.s && a.b == b.b;
    }
}

class Info implements Comparable<Info> {
    int idx, g, s, b;

    public Info(int idx, int g, int s, int b) {
        this.idx = idx;
        this.g = g;
        this.s = s;
        this.b = b;
    }

    @Override
    public int compareTo(Info o) {
        if (this.g == o.g) {
            if (this.s == o.s) {
                return o.b - this.b;
            } else {
                return o.s - this.s;
            }
        } else {
            return o.g - this.g;
        }
    }
}