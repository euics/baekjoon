import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        long sum = 0;
        int cnt = 0;
        for(int i = n; i >= 1; i--){
            cnt++;
            if(cnt == 3)
                cnt = 0;
            else
                sum += arr[i];
        }

        System.out.println(sum);
    }
}
