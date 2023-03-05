import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for(int i = 0; i < a; i++)
        {
            int num = scanner.nextInt();
            if(num < b)
            {
                System.out.printf("%d " , num);
            }
        }
    }
}