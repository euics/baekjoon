import java.util.Scanner;

class Solution {
    static int max = Integer.MIN_VALUE;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            char[] ch = sc.next().toCharArray();
            int change = sc.nextInt();
            max = Integer.MIN_VALUE;
            findMaxPrize(ch, change, 0);

            System.out.printf("#%d %d\n", test_case, max);
        }
        sc.close();
    }

    public static void findMaxPrize(char[] ch, int change, int s){
        if(change == 0){
            max = Math.max(max, Integer.parseInt(new String(ch)));
            return;
        }

        for(int i = s; i < ch.length; i++) {
            for(int j = i + 1; j < ch.length; j++) {
                swap(ch, i, j);
                findMaxPrize(ch, change - 1, i);
                swap(ch, i, j);
            }
        }
    }

    public static void swap(char[] ch, int i, int j){
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }
}
