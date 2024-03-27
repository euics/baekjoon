import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        int[] rules = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) rules[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[] tmp = new int[4];
        for(int i = 0; i < p; i++) {
            if(str.charAt(i) == 'A') tmp[0]++;
            if(str.charAt(i) == 'C') tmp[1]++;
            if(str.charAt(i) == 'G') tmp[2]++;
            if(str.charAt(i) == 'T') tmp[3]++;
        }

        if(checkArr(tmp, rules)) answer++;

        for(int end = p, start = 0; end < s; end++) {
            if(str.charAt(start) == 'A') tmp[0]--;
            if(str.charAt(start) == 'C') tmp[1]--;
            if(str.charAt(start) == 'G') tmp[2]--;
            if(str.charAt(start) == 'T') tmp[3]--;

            if(str.charAt(end) == 'A') tmp[0]++;
            if(str.charAt(end) == 'C') tmp[1]++;
            if(str.charAt(end) == 'G') tmp[2]++;
            if(str.charAt(end) == 'T') tmp[3]++;

            if(checkArr(tmp, rules)) answer++;
            start++;
        }

        System.out.println(answer);
    }

    public static boolean checkArr(int[] tmp, int[] rules) {
        for(int i = 0; i < 4; i++) {
            if(tmp[i] < rules[i]) return false;
        }

        return true;
    }
}

// 4
// AACCTTG
// 2 2 2 1
// 1 0 0 1
// 1 2 2 0
// AG *

// A C G T