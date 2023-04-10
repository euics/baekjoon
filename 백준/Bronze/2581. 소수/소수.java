import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer> prime = findPrime(n, m);
        int sum = 0;
        for(int x : prime)
            sum += x;

        if(sum == 0)
            System.out.println(-1);
        else{
            System.out.printf("%d\n%d", sum, prime.get(0));
        }
    }

    private static List<Integer> findPrime(int a, int b){
        boolean[] bool = new boolean[b + 1];
        for(int i = 0; i <= b; i++)
            bool[i] = true;
        bool[0] = false;
        bool[1] = false;

        for(int i = 2; i * i <= b; i++){
            for(int j = i * i; j <= b; j += i)
                bool[j] = false;
        }

        List<Integer> prime = new LinkedList<>();
        for(int i = a; i <= b; i++){
            if(bool[i])
                prime.add(i);
        }

        return prime;
    }
}