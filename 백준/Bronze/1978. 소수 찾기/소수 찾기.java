import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        List<Integer> prime = findPrime(max);
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(prime.contains(arr[i]))
                cnt++;
        }

        System.out.println(cnt);
    }

    private static List<Integer> findPrime(int max){
        boolean[] bool = new boolean[max + 1];
        for(int i = 1; i <= max; i++)
            bool[i] = true;
        bool[1] = false;

        for(int i = 2; i * i <= max; i++){
            for(int j = i * i; j <= max; j += i){
                bool[j] = false;
            }
        }

        List<Integer> list = new LinkedList<>();
        for(int i = 1; i <= max; i++){
            if(bool[i])
                list.add(i);
        }

        return list;
    }
}