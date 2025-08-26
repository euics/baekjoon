import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "add": {
                    int x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;
                }
                case "remove": {
                    int x = Integer.parseInt(st.nextToken());
                    set.remove(x);
                    break;
                }
                case "check": {
                    int x = Integer.parseInt(st.nextToken());
                    sb.append(set.contains(x) ? 1 : 0).append('\n');
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(st.nextToken());
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                }
                case "all": {
                    set.clear();
                    for (int j = 1; j <= 20; j++) set.add(j);
                    break;
                }
                case "empty": {
                    set.clear();
                    break;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
