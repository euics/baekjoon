import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // 1 2 3 3 4
        int sum = 0, total = 0;
        for(int i = 1; i <= n; i++){
            sum = sum + arr[i];
            total += sum;
        }

        System.out.println(total);
    }
}

/*
 P1 = 3
 P2 = 1
 P3 = 4
 P4 = 3
 P5 = 2

 1
 1 2
 1 2 3
 1 2 3 3
 1 2 3 3 4
*/