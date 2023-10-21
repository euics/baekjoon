import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer> broken = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        if(m > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++)
                broken.add(Integer.parseInt(st.nextToken()));
        }

        int answer = Math.abs(n - 100);
        for(int i = 0; i <= 999999; i++){
            String channel = String.valueOf(i);
            boolean contain = false;

            for(int j = 0; j < channel.length(); j++){
                if(broken.contains(channel.charAt(j) - '0')){
                    contain = true;
                    break;
                }
            }

            if(contain)
                continue;

            int cntClick = channel.length() + Math.abs(n - Integer.parseInt(channel));
            answer = Math.min(answer, cntClick);
        }

        System.out.println(answer);
    }
}