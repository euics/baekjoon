import java.util.*;
import java.io.*;

public class Main {
    static int t, a, b;
    static String answer = "";

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
        Queue<Pair> q = new LinkedList<>();
        boolean[] bool = new boolean[10000];

        q.add(new Pair(a, " "));
        bool[a] = true;

        while(!q.isEmpty()){
            Pair o = q.poll();

            if(o.value == b)
                return o.command;

            int d = (o.value * 2) % 10000;
            int s = (o.value == 0) ? 9999 : o.value - 1;
            int l = (o.value % 1000) * 10 + (o.value / 1000);
            int r = (o.value % 10) * 1000 + (o.value / 10);

            if(!bool[d]) {
                q.add(new Pair(d, o.command + "D"));
                bool[d] = true;
            }

            if(!bool[s]) {
                q.add(new Pair(s, o.command + "S"));
                bool[s] = true;
            }

            if(!bool[l]) {
                q.add(new Pair(l, o.command + "L"));
                bool[l] = true;
            }

            if(!bool[r]) {
                q.add(new Pair(r, o.command + "R"));
                bool[r] = true;
            }
        }

        return "";
    }
}

class Pair {
    int value;
    String command;

    public Pair(int value, String command){
        this.value = value;
        this.command = command;
    }
}