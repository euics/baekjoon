import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.add('(');
            } else{
                if(str.charAt(i - 1) == ')'){
                    stack.pop();
                    cnt++;
                } else{
                    stack.pop();
                    cnt += stack.size();
                }
            }
        }
        
        System.out.println(cnt);
    }
}
