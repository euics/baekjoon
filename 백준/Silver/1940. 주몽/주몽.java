import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int left = 0, right = n - 1;
        int answer = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum > m) {
                right--;
            } else if(sum < m) {
                left++;
            } else {
                answer++;
                left++;
                right--;
            }
        }

        System.out.println(answer);
    }
}

// 1 2 2 4 5 7