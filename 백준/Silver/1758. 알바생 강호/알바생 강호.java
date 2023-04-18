import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long sum = 0;
        for(int i = n - 1; i>= 0; i--){
            int tmp = arr[i] - (n - i - 1);
            if(tmp > 0)
                sum += tmp;
        }

        System.out.println(sum);
    }
}