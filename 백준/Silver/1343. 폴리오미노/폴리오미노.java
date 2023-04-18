import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replaceAll("XXXX", "AAAA");
        str = str.replaceAll("XX", "BB");

        if(str.contains("X"))
            System.out.println(-1);
        else
            System.out.println(str);
    }
}