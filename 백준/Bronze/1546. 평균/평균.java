import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int max = Arrays.stream(arr).max().getAsInt();
        float sum = 0;
        for(int x : arr)
            sum += (float) x / max * 100;

        System.out.println(sum / n);

    }
}