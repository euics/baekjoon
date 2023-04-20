import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        int[] dis = new int[n];
//        for(int i = 0; i < n; i++)
//            dis[i] = Integer.parseInt(br.readLine());
//
//        int cnt = 0;
//        for(int i = n - 1; i >= 0; i--){
//            if(dis[i] <= k){
//                cnt += k / dis[i];
//                k %= dis[i];
//            }
//        }
//
//        System.out.println(cnt);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ropes = new int[n];

        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }

        Arrays.sort(ropes);

        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            int weight = ropes[i] * (n - i);
            maxWeight = Math.max(maxWeight, weight);
        }

        System.out.println(maxWeight);
    }
}
