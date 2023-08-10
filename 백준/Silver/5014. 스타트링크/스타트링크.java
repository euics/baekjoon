import java.util.*;
import java.io.*;

public class Main {
    static int f, s, g, u, d, cnt = 0, min = Integer.MAX_VALUE;
    static boolean[] bool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        bool = new boolean[f + 1];

        int result = BFS();
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    private static int BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0});

        while(!q.isEmpty()){
            int[] o = q.poll();
            int floor = o[0];
            int count = o[1];

            if(floor == g)
                return count;

            if(floor + u <= f && !bool[floor + u]){
                bool[floor + u] = true;
                q.add(new int[]{floor + u, count + 1});
            }

            if(floor - d > 0 && !bool[floor - d]){
                bool[floor - d] = true;
                q.add(new int[]{floor - d, count + 1});
            }
        }

        return -1;
    }
}