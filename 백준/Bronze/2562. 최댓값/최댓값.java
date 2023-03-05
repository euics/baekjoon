import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);

        for(int i = 0; i < 9; i++){
            if(max == arr[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}