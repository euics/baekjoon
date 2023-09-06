import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        System.out.println(solution(str));
    }

    private static int solution(String str){
        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        int result = 0;

        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);

            switch(cur){
                case '(':
                    stack.push(cur);
                    tmp *= 2;
                    break;

                case '[':
                    stack.push(cur);
                    tmp *= 3;
                    break;

                case ')':
                    if(stack.isEmpty() || stack.peek() != '(')
                        return 0;

                    if(str.charAt(i - 1) == '(')
                        result += tmp;

                    stack.pop();
                    tmp /= 2;

                    break;

                case ']':
                    if(stack.isEmpty() || stack.peek() != '[')
                        return 0;

                    if(str.charAt(i - 1) == '[')
                        result += tmp;

                    stack.pop();
                    tmp /= 3;

                    break;
            }
        }
        
        if(!stack.isEmpty())
            return 0;

        return result;
    }
}