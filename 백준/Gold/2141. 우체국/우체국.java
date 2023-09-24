import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        long totalPeople = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                totalPeople += arr[i][1];
            }
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        long people = 0;
        for(int i = 0; i < n; i++){
            people += arr[i][1];
            if(people >= (totalPeople + 1) / 2){
                System.out.println(arr[i][0]);
                break;
            }
        }
    }
}