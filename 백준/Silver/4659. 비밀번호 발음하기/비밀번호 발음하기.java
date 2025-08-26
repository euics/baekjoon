import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String password = st.nextToken();
            if (password.equals("end")) break;

            if (rule(password)) sb.append("<").append(password).append("> ").append("is acceptable.\n");
            else sb.append("<").append(password).append("> ").append("is not acceptable.\n");
        }

        System.out.println(sb.toString());
    }

    private final static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public static boolean rule(String password) {
        int cnt = 0;
        for (char c : password.toCharArray()) if (vowels.contains(c)) cnt++;
        if (cnt == 0) return false;

        for (int i = 0; i <= password.length() - 3; i++) {
            int vowel = 0, verb = 0;

            for (int j = i; j < i + 3; j++) {
                if (vowels.contains(password.charAt(j))) vowel++;
                else verb++;
            }

            if (vowel == 3 || verb == 3) return false;
        }

        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                StringBuilder sb = new StringBuilder().append(password.charAt(i)).append(password.charAt(i + 1));
                if (!sb.toString().equals("ee") && !sb.toString().equals("oo")) return false;
            }
        }

        return true;
    }
}