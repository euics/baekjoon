import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            LinkedList<Info> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                list.add(new Info(j, Integer.parseInt(st.nextToken())));

            int cnt = 0;
            while(!list.isEmpty()){
                Info o = list.pollFirst();
                boolean flag = true;

                for(int l = 0; l < list.size(); l++){
                    if(list.get(l).priority > o.priority){
                        list.add(o);
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    if(o.idx == idx) {
                        System.out.println(cnt + 1);
                        break;
                    } else
                        cnt++;
                }
            }
        }
    }
}

class Info {
    int idx, priority;
    public Info(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}