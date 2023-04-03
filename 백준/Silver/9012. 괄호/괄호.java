import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            char[] ch = str.toCharArray();

            for(char a : ch){
                if(a == '(')
                    stack.add(a);
                else{
                    if(stack.isEmpty()) {
                        stack.add(a);
                        break;
                    }
                    else
                        stack.pop();
                }
            }

            if(stack.isEmpty())
                sb.append("YES" + "\n");
            else
                sb.append("NO" + "\n");

            stack.clear();
        }

        System.out.println(sb);
    }
}
