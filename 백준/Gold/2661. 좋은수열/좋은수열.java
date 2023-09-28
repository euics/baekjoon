import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        solution("");
    }

    private static void solution(String str){
        if(str.length() == n){
            System.out.println(str);
            System.exit(0);
        }

        for(int i = 1; i <= 3; i++){
            if(canMakeStr(str + i))
                solution(str + i);
        }
    }

    private static boolean canMakeStr(String str){
        for(int i = 1; i <= str.length() / 2; i++){
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if(front.equals(back))
                return false;
        }

        return true;
    }
}