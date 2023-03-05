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

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(sortedArr[i]))
                map.put(sortedArr[i], index++);
        }

        StringBuilder sb = new StringBuilder();
        for(int x : arr)
            sb.append(map.get(x)).append(" ");

        System.out.println(sb);
    }
}
