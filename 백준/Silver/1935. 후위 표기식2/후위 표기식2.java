import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        double[] arr = new double[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch >= 'A' && ch <= 'Z')
                stack.add(arr[ch - 'A']);
            else{

                double second = stack.pop();
                double first = stack.pop();

                switch(ch){
                    case '+':
                        stack.add(first + second);
                        break;
                    case '-':
                        stack.add(first - second);
                        break;
                    case '*':
                        stack.add(first * second);
                        break;
                    case '/':
                        stack.add(first / second);
                        break;
                }
            }
        }

        double answer = stack.pop();
        System.out.printf("%.2f", answer);
    }
}