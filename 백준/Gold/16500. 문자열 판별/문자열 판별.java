import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();

        for(int i = 0; i < n; i++)
            words.add(br.readLine());

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && words.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        if (dp[s.length()]) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}