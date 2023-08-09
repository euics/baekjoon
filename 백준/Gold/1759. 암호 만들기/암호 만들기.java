import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static char[] arr;
    static boolean[] bool;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        bool = new boolean[C];

        char[] ch = br.readLine().toCharArray();
        int index = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != ' ')
                arr[index++] = ch[i];
        }
        Arrays.sort(arr);

        DFS(0, "");
    }

    private static void DFS(int start, String answer){
        if(answer.length() == L) {
            check(answer);
            return;
        }

        for(int i = start; i < C; i++){
            if(!bool[i]){
                bool[i] = true;
                DFS(i + 1, answer + arr[i]);
                bool[i] = false;
            }
        }
    }

    private static void check(String answer){
        int vowels = 0, consonants = 0;
        for(int i = 0; i < answer.length(); i++){
            if("aeiou".contains(answer.charAt(i) + ""))
                vowels++;
            else
                consonants++;
        }

        if (vowels >= 1 && consonants >= 2)
            System.out.println(answer);
    }
}