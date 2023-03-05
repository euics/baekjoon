
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i = 0; i < n; i++)
        {
            int m = scanner.nextInt();
            String str = scanner.next();

            for(int j = 0; j < str.length(); j++) 
            {
                for (int k = 0; k < m; k++) 
                {
                    System.out.printf("%c", str.charAt(j));
                }
            }
            System.out.println();
        }
    }
}