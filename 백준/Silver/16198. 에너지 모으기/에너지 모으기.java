import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) numbers.add(Integer.parseInt(st.nextToken()));

        DFS(numbers, 0);
        System.out.println(max);
    }

    public static void DFS(ArrayList<Integer> numbers, int sum) {
        if (numbers.size() == 2) {
            max = Math.max(max, sum);

            return;
        }

        for (int i = 1; i < numbers.size() - 1; i++) {
            int energy = numbers.get(i - 1) * numbers.get(i + 1);
            int remove = numbers.remove(i);
            DFS(numbers, sum + energy);
            numbers.add(i, remove);
        }
    }
}