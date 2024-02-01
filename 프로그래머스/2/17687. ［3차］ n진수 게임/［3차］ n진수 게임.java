import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder number = new StringBuilder();
        number.append(0);

        for(int i = 0; ; i++){
            String num = convert(i, n);

            if(number.toString().length() < t * m) number.append(num);
            else break;
        }

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < number.length(); i++){
            if(t == 0) break;

            if(i % m + 1 == p){
                answer.append(number.toString().charAt(i));
                t--;
            }
        }

        return answer.toString();
    }

    public String convert(int num, int n) {
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            int remain = num % n;

            switch (remain) {
                case 10:
                    sb.insert(0, "A");
                    break;
                case 11:
                    sb.insert(0, "B");
                    break;
                case 12:
                    sb.insert(0, "C");
                    break;
                case 13:
                    sb.insert(0, "D");
                    break;
                case 14:
                    sb.insert(0, "E");
                    break;
                case 15:
                    sb.insert(0, "F");
                    break;
                default:
                    sb.insert(0, String.valueOf(remain));
                    break;
            }
            num /= n;
        }

        return sb.toString();
    }
}