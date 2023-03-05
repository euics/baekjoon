import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, i);
            arr[i] = str;
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            String str = br.readLine();
            if(Character.isAlphabetic(str.charAt(0)))
                sb.append(map.get(str) + 1).append("\n");
            else
                sb.append(arr[Integer.parseInt(str) - 1]).append("\n");
        }

        System.out.println(sb);
    }
}