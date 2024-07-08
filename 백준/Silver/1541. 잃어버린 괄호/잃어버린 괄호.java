import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splitBySubtraction = br.readLine().split("-");

        int sum = Integer.MAX_VALUE;
        for (String value : splitBySubtraction) {
            int tmp = 0;

            String[] splitByAddition = value.split("\\+");

            for (String s : splitByAddition)
                tmp += Integer.parseInt(s);

            if (sum == Integer.MAX_VALUE)
                sum = tmp;
            else
                sum -= tmp;
        }

        System.out.println(sum);
    }
}