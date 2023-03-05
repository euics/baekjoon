import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < 28; i++)
            arrList.add(Integer.parseInt(br.readLine()));

        for(int i = 1; i <= 30; i++){
            if(!arrList.contains(i))
                System.out.println(i);
        }
    }
}