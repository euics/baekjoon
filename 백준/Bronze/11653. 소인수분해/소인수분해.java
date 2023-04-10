import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int divider = 2;
        while(n != 1){
            if(n % divider == 0) {
                n /= divider;
                System.out.println(divider);
                divider = 2;
            } else
                divider++;
        }
    }
}