import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty())
                        sb.append(-1 + "\n");
                    else
                        sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty())
                        sb.append(-1 + "\n");
                    else
                        sb.append(deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty())
                        sb.append(1 + "\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    if(deque.isEmpty())
                        sb.append(-1 + "\n");
                    else
                        sb.append(deque.peekFirst()).append("\n");
                    break;
                case "back":
                    if(deque.isEmpty())
                        sb.append(-1 + "\n");
                    else
                        sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
