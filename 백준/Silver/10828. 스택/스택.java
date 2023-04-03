
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            switch(str){
                case "push":
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.isEmpty())
                        sb.append(stack.pop()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "top":
                    if(stack.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(stack.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
