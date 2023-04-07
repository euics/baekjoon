import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Top> s = new Stack<>();
        int index = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("0 ");
        s.add(new Top(index++, Integer.parseInt(st.nextToken())));
        for(int i = 0; i < n - 1; i++){
            int tmp = Integer.parseInt(st.nextToken());

            if(s.peek().height < tmp) {

                while(s.peek().height < tmp) {
                    s.pop();
                    if(s.isEmpty()) {
                        sb.append("0 ");
                        break;
                    }
                }

                if(!s.isEmpty())
                    sb.append(s.peek().index).append(" ");

                s.add(new Top(index++, tmp));

            } else{
                sb.append(s.peek().index).append(" ");
                s.add(new Top(index++, tmp));
            }
        }

        System.out.println(sb);
    }

    private static class Top{
        int index;
        int height;

        public Top(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
}
