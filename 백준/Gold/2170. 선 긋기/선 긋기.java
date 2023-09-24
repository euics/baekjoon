import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Info[] info = new Info[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(info);

        long length = 0;
        int start = info[0].x;
        int end = info[0].y;

        for(int i = 1; i < n; i++){
            if(info[i].x <= end){ // 선분이 겹칠 경우
                end = Math.max(end, info[i].y);
            } else {
                length += end - start;
                start = info[i].x;
                end = info[i].y;
            }
        }
        length += end - start;

        System.out.println(length);
    }
}

class Info implements Comparable<Info>{
    int x, y;
    public Info(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Info o){
        if(this.x == o.x)
            return this.y - o.y;
        else
            return this.x - o.x;
    }
}
