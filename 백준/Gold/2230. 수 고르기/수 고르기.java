import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0, right = 0, min = Integer.MAX_VALUE;
        while(left <= right && right < n) {
            if(arr[right] - arr[left] >= m) {
                min = Math.min(min, arr[right] - arr[left]);
                left++;
            } else right++;
        }

        System.out.println(min);
    }
}