import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int total = 0;
        Map<String, Integer> map = new HashMap<>();
        while ((s = br.readLine()) != null) {
            total++;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        LinkedList<String> keySet = new LinkedList<>(map.keySet());
        Collections.sort(keySet);

        for(String key : keySet)
            System.out.printf("%s %.4f\n", key,  ((double)map.get(key) / total) * 100);
    }
}