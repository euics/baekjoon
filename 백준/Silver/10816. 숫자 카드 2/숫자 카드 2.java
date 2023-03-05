import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[n];
        for(int i = 0; i < m; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            if(map.containsKey(arr2[i]))
                sb.append(map.get(arr2[i])).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}