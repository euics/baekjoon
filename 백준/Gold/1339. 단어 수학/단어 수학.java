import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        Integer[] alpha = new Integer[26];
        Arrays.fill(alpha, 0);

        for(int i = 0; i < n; i++){
            String input = br.readLine();

            int size = input.length();

            int pow = (int)Math.pow(10, size - 1);

            for(int j = 0; j < size; j++){
                alpha[input.charAt(j) - 'A'] += pow;
                pow /= 10;
            }
        }

        Arrays.sort(alpha, Collections.reverseOrder());

        int maxNum = 9, answer = 0;
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 0)
                break;

            answer += alpha[i] * maxNum;
            maxNum--;
        }

        System.out.println(answer);
    }
}