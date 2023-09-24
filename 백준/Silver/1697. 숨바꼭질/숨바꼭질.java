import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] bool = new boolean[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        bool[n] = true;
        q.add(new int[]{n, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == k){
                System.out.println(cur[1]);
                break;
            }

            int[] dix = {cur[0] - 1, cur[0] + 1, cur[0] * 2};
            for(int nx : dix){
                if(nx >= 0 && nx <= 100000){
                    if(!bool[nx]){
                        bool[nx] = true;
                        q.add(new int[]{nx, cur[1] + 1});
                    }
                }
            }
        }
    }
}