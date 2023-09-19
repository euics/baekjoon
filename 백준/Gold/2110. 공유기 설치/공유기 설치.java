import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 1, right = arr[n - 1] - arr[0];
        int result = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int countC = countC(mid, arr);

            if(countC >= c){
                left = mid + 1;
                result = mid;
            } else
                right = mid - 1;
        }

        System.out.println(result);
    }

    private static int countC(int length, int[] arr){
        int cnt = 1;
        for(int i = 1, idx = 0; i < arr.length; i++){
            if(arr[i] - arr[idx] >= length){
                idx = i;
                cnt++;
            }
        }

        return cnt;
    }
}