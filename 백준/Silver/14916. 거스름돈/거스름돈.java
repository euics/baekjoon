import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//
//        Queue<Integer> q = new LinkedList<>();
//        q.add(0);
//        int[] dis = {2, 5};
//        int L = 0;
//        int answer = 0;
//        while(!q.isEmpty()){
//            int size = q.size();
//            for(int i = 0; i < size; i++){
//                int x = q.poll();
//
//                if(x == n) {
//                    answer = L;
//                    break;
//                }
//
//                for(int j = 0; j < 2; j++){
//                    int tmp = x + dis[j];
//                    if(tmp <= n && !q.contains(tmp))
//                        q.add(tmp);
//                }
//            }
//
//            if(answer != 0)
//                break;
//
//            L++;
//        }
//
//        if(answer == 0)
//            System.out.println(-1);
//        else
//            System.out.println(answer);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = -1;

        for (int i = 0; i <= n / 2; i++) {
            if ((n - (2 * i)) % 5 == 0) {
                result = i + ((n - (2 * i)) / 5);
                break;
            }
        }

        System.out.println(result);
    }
}
