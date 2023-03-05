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
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            boolean bool = false;
            int tmp = Integer.parseInt(st.nextToken());
            int lt = 0, rt = arr.length - 1;
            while(lt <= rt){
                int mid = (lt + rt) / 2;
                if(arr[mid] > tmp)
                    rt = mid - 1;
                else if(arr[mid] < tmp)
                    lt = mid + 1;
                else {
                    sb.append(1).append("\n");
                    bool = true;
                    break;
                }
            }
            if(!bool)
                sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}
