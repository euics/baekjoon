import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(Integer.parseInt(st.nextToken()), i);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp))
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}
