import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int index = 0;
        for(int i = 1; i <= n; i++){
            s.add(i);
            sb.append("+\n");

            while(s.peek() == arr[index]){
                s.pop();
                sb.append("-\n");
                index++;

                if(s.isEmpty())
                    break;
            }
        }

        if(index == n)
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
