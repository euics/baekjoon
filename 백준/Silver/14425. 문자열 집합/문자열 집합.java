import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(br.readLine());

        int cnt = 0;
        for(int i = 0; i < m; i++){
            if(set.contains(br.readLine()))
                cnt++;
        }

        System.out.println(cnt);
    }
}