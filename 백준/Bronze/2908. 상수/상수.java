import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        String reverseA = String.valueOf(new StringBuffer(a).reverse());
        String reverseB = String.valueOf(new StringBuffer(b).reverse());

        int integerA = Integer.valueOf(reverseA);
        int integerB = Integer.valueOf(reverseB);

        System.out.printf("%d", Math.max(integerA, integerB));
    }
}
