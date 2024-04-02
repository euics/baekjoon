class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);

        for (int i = 0; ; i++) {
            String num = convert(n, i);

            if(sb.toString().length() < t * m)  sb.append(num);
            else break;
        }

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < sb.toString().length(); i++) {
            if(t == 0) break;
            
            if(i % m == p - 1) {
                answer.append(sb.toString().charAt(i));
                t--;
            }
        }

        return answer.toString();
    }

    public String convert(int n, int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int remain = num % n;
            switch (remain) {
                case 10:
                    sb.insert(0, 'A');
                    break;
                case 11:
                    sb.insert(0, 'B');
                    break;
                case 12:
                    sb.insert(0, 'C');
                    break;
                case 13:
                    sb.insert(0, 'D');
                    break;
                case 14:
                    sb.insert(0, 'E');
                    break;
                case 15:
                    sb.insert(0, 'F');
                    break;
                default:
                    sb.insert(0, remain);
                    break;
            }

            num /= n;
        }

        return sb.toString();
    }
}