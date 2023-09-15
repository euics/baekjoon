import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int lowLength = 1, highLength = arr[n - 1] - arr[0] + 1;
        int result = 0;
        while(lowLength <= highLength){
            int midLength = (lowLength + highLength) / 2;

            if(install(midLength) >= c){
                lowLength = midLength + 1;
                result = midLength;
            } else
                highLength = midLength - 1;
        }

        System.out.println(result);
    }

    private static int install(int length){
        int cnt = 1;
        int lastInstallLocation = arr[0];

        for(int i = 1; i < arr.length; i++){
            int curLocation = arr[i];

            if(curLocation - lastInstallLocation >= length){
                cnt++;
                lastInstallLocation = curLocation;
            }
        }

        return cnt;
    }
}