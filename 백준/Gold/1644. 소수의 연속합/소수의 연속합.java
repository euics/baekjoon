import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrList = findPrime(n);
        int[] arr = new int[arrList.size() + 1];
        for(int i = 0; i < arrList.size(); i++)
            arr[i] = arrList.get(i);

        int lt = 0, rt = 0;
        int sum = 0, cnt = 0;
        while(lt <= arr.length && rt <= arr.length){
            if(sum >= n) {
                if(sum == n)
                    cnt++;
                sum -= arr[lt++];
            }
            else {
                if(rt == arr.length)
                    break;
                sum += arr[rt++];
            }
        }

        System.out.println(cnt);
    }

    private static ArrayList<Integer> findPrime(int n){
        boolean[] bool = new boolean[n + 1];
        for(int i = 0; i <= n; i++)
            bool[i] = true;
        bool[0] = false;
        bool[1] = false;

        for(int i = 2; i * i <= n; i++){
            for(int j = i * i; j <= n; j += i)
                bool[j] = false;
        }

        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(bool[i])
                arrList.add(i);
        }

        return arrList;
    }
}
