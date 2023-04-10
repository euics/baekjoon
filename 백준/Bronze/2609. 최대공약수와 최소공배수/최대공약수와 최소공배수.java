import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b= new BigInteger(st.nextToken());

        System.out.println(a.gcd(b).intValue());
        System.out.println(b.multiply(a).intValue() / a.gcd(b).intValue());
    }
}