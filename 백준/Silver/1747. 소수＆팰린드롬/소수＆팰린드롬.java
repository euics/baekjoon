import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(true){
            String str = String.valueOf(n);
            String tmp = new StringBuilder(str).reverse().toString();
            int answer = 0, cnt = 0;
            if(str.equals(tmp)){
                for(int i = 1; i <= n; i++){
                    if(n % i == 0){
                        cnt++;
                    }
                }

                if(cnt == 2)
                    answer = n;
            }

            if(answer == n) {
                System.out.println(answer);
                break;
            } else
                n++;
        }
    }

    private static List<Integer> prime(int n){
        boolean[] bool = new boolean[n + 1];
        for(int i = 0; i <= n; i++)
            bool[i] = true;
        bool[0] = false;
        bool[1] = false;

        for(int i = 2; i * i <= n; i++){
            for(int j = i * i; j <= n; j += i)
                bool[j] = false;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(bool[i])
                list.add(i);
        }

        return list;
    }
}