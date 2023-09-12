import java.io.*;
import java.util.*;

public class Main {
    static int t, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(BFS());
        }
    }

    private static String BFS(){
        Queue<Info> q = new LinkedList<>();
        boolean[] bool = new boolean[10000];
        q.add(new Info(a, ""));
        bool[a] = true;

        while(!q.isEmpty()){
            Info cur = q.poll();

            if(cur.value == b)
                return cur.command;

            int d = (cur.value * 2) % 10000;
            int s = (cur.value == 0) ? 9999 : cur.value - 1;
            int l = (cur.value % 1000) * 10 + (cur.value / 1000);
            int r = (cur.value % 10) * 1000 + (cur.value / 10);

            if(!bool[d]){
                q.add(new Info(d, cur.command + "D"));
                bool[d] = true;
            }

            if(!bool[s]){
                q.add(new Info(s, cur.command + "S"));
                bool[s] = true;
            }

            if(!bool[l]){
                q.add(new Info(l, cur.command + "L"));
                bool[l] = true;
            }

            if(!bool[r]){
                q.add(new Info(r, cur.command + "R"));
                bool[r] = true;
            }
        }

        return "";
    }
}

class Info {
    int value;
    String command;
    public Info(int value, String command){
        this.value = value;
        this.command = command;
    }
}