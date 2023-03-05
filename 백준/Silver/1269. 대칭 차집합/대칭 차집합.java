import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < n; i++)
            a.put(Integer.parseInt(st.nextToken()), i);

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> b = new HashMap<>();
        for (int i = 0; i < m; i++)
            b.put(Integer.parseInt(st.nextToken()), i);

        int cnt = 0;
        for(int key : b.keySet()){
            if(!a.containsKey(key))
                cnt++;
        }
        for(int key : a.keySet()){
            if(!b.containsKey(key))
                cnt++;
        }

        System.out.println(cnt);
    }
}