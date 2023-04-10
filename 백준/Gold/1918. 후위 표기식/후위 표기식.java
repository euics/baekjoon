import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 'A')
                sb.append(str.charAt(i));
            else{
                switch(str.charAt(i)){
                    case '+':
                        while(!s.isEmpty() && (s.peek() == '*' || s.peek() == '-' || s.peek() == '/' || s.peek() == '+'))
                            sb.append(s.pop());

                        s.add('+');

                        break;
                    case '-':
                        while(!s.isEmpty() && (s.peek() == '*' || s.peek() == '-' || s.peek() == '/' || s.peek() == '+'))
                            sb.append(s.pop());
                        s.add('-');

                        break;
                    case '*':
                        while(!s.isEmpty() && (s.peek() == '/' || s.peek() == '*'))
                            sb.append(s.pop());
                        s.add('*');

                        break;

                    case '/':
                        while(!s.isEmpty() && (s.peek() == '/' || s.peek() == '*'))
                            sb.append(s.pop());
                        s.add('/');

                        break;

                    case '(':
                        s.add('(');

                        break;

                    case ')':
                        while(!s.isEmpty() && s.peek() != '(')
                            sb.append(s.pop());
                        s.pop();

                        break;
                }
            }
        }

        while(!s.isEmpty())
            sb.append(s.pop());

        System.out.println(sb);
    }
}