import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= a; i++)
            deque.addLast(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!deque.isEmpty()){
            for(int i = 1; i < b; i++)
                deque.addLast(deque.pollFirst());
            sb.append(deque.pollFirst());
            if(!deque.isEmpty())
                sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
