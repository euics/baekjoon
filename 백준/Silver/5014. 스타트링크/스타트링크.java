import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d, answer = Integer.MAX_VALUE;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken()); // 건물 총 층 수
        s = Integer.parseInt(st.nextToken()); // 강호가 있는 층
        g = Integer.parseInt(st.nextToken()); // 목적지
        u = Integer.parseInt(st.nextToken()); // 올라가는 버튼
        d = Integer.parseInt(st.nextToken()); // 내려가는 버튼
        dis = new int[f + 1];

        solution();

        if(dis[g] == 0 && g != s)
            System.out.println("use the stairs");
        else
            System.out.println(dis[g]);
    }

    private static void solution(){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()){
             int curStair = q.poll();

            if(curStair == g)
                return;

            //다음 up 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if(curStair + u <= f && u > 0){
                if(dis[curStair + u] == 0){
                    dis[curStair + u] = dis[curStair] + 1;
                    q.add(curStair + u);
                }
            }

            //다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if(curStair - d >= 1 && d > 0){
                if(dis[curStair - d] == 0){
                    dis[curStair - d] = dis[curStair] + 1;
                    q.add(curStair - d);
                }
            }
        }
    }
}