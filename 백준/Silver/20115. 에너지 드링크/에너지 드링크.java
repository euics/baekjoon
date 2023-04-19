import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        float[] arr = new float[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Float.parseFloat(st.nextToken());

        Arrays.sort(arr);

        for(int i = 0; i < n - 1; i++)
            arr[i] /= 2;

        float sum = 0;
        for(int i = 0; i < n - 1; i++)
            sum += arr[i];

        sum += arr[n - 1];

        System.out.println(sum);
    }
}
