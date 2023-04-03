import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push"))
                deque.addLast(Integer.parseInt(String.valueOf(str[1])));
            if(str[0].equals("pop")){
                if(deque.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(deque.pollFirst()).append("\n");
            }
            if(str[0].equals("size"))
                sb.append(deque.size()).append("\n");
            if(str[0].equals("empty")){
                if(deque.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            if(str[0].equals("front")){
                if(!deque.isEmpty())
                    sb.append(deque.peekFirst()).append("\n");
                else
                    sb.append(-1).append("\n");
            }
            if(str[0].equals("back")){
                if(!deque.isEmpty())
                    sb.append(deque.peekLast()).append("\n");
                else
                    sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}