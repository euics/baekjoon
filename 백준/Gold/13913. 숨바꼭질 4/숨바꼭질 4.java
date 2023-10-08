import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int MAX = 100001;
    static boolean[] visited = new boolean[MAX];
    static int[] dist = new int[MAX];
    static int[] from = new int[MAX];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        BFS();
        System.out.println(dist[k]);

        Stack<Integer> s = new Stack<>();
        for(int v = k; v != n; v = from[v])
            s.push(v);
        s.push(n);

        while(!s.isEmpty())
            System.out.printf("%d ", s.pop());
    }

    private static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        dist[n] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == k)
                return;

            int[] dx = {cur - 1, cur + 1, cur * 2};
            for(int d = 0; d < 3; d++){
                if(dx[d] >= 0 && dx[d] < MAX && !visited[dx[d]]){
                    visited[dx[d]] = true;
                    q.add(dx[d]);
                    dist[dx[d]] = dist[cur] + 1;
                    from[dx[d]] = cur;
                }
            }
        }
    }
}