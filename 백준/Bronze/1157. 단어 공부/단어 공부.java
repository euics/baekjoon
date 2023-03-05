import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        int arr[] = new int[26];

        for(int i = 0; i < 26; i++)
            arr[i] = 0;

        String lowercase = str.toLowerCase(Locale.ROOT);

        for(int i = 0; i < lowercase.length(); i++)
        {
            char ch = lowercase.charAt(i);

            arr[ch - 'a']++;
        }

        int max = -1;

        char ch = '?';

        for(int i = 0; i < arr.length; i++)
        {
            if(max < arr[i])
            {
                max = arr[i];

                ch = (char)(i + 65);
            }
            else if(arr[i] == max)
                ch = '?';
        }
        System.out.println(ch);
    }
}