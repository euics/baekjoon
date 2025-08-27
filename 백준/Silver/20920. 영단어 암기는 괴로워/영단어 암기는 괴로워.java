import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> dictionary = new HashSet<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() >= M) {
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
                dictionary.add(word);
            }
        }

        LinkedList<String> sort = new LinkedList<>(dictionary);
        Collections.sort(sort, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (!cnt.get(o1).equals(cnt.get(o2))) return cnt.get(o2) - cnt.get(o1);
                if (o1.length() != o2.length()) return o2.length() - o1.length();
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word : sort) sb.append(word).append("\n");
        System.out.println(sb.toString());
    }
}