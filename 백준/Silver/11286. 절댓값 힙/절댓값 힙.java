import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>(){
            @Override
            public int compare(Long o1, Long o2){
                if(Math.abs(o1) == Math.abs(o2))
                    return (int) (o1 - o2);
                else
                    return (int) (Math.abs(o1) - Math.abs(o2));
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            Long tmp = Long.parseLong(br.readLine());

            if(tmp == 0){
                if(pq.size() == 0)
                    sb.append("0\n");
                else
                    sb.append(pq.poll()).append("\n");
            } else
                pq.add(tmp);
        }

        System.out.println(sb);

        br.close();
    }
}
