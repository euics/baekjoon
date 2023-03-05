import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int n = Integer.valueOf(str[0]);
        int m = Integer.valueOf(str[1]);

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(br.readLine());

        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String tmp = br.readLine();
            if(set.contains(tmp))
                answer.add(tmp);
        }
        
        Collections.sort(answer);

        System.out.println(answer.size());
        for(int i = 0; i < answer.size(); i++)
            System.out.println(answer.get(i));
    }
}