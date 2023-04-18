import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
            max = Math.max(max, arr[i]);

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(arr[i]);

        List<Integer> prime = prime(max);

        long answer = 1;
        for(int x : set){
            if(prime.contains(x))
                answer *= x;
        }

        if(answer == 1)
            System.out.println(-1);
        else
            System.out.println(answer);
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