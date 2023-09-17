import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(l);
        if(n > 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int left = 1, right = l;
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            for(int i = 1; i < list.size(); i++)
                cnt += (list.get(i) - list.get(i - 1) - 1) / mid;

            if(cnt > m)
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println(left);
    }
}