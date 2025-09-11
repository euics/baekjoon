import java.util.*;

class Solution {
    static long ans = Long.MIN_VALUE;
    static char[] ch = new char[]{'+', '-', '*'};
    static char[] permutation = new char[3];

    public long solution(String expression) {
        permutation(0, new boolean[3], expression);

        return ans;
    }

    public void permutation(int L, boolean[] bool, String expression) {
        if (L == 3) {
            ans = Math.max(ans, Math.abs(sum(expression)));

            return;
        }

        for (int i = 0; i < ch.length; i++) {
            if (!bool[i]) {
                bool[i] = true;
                permutation[L] = ch[i];
                permutation(L + 1, bool, expression);
                bool[i] = false;
            }
        }
    }

    public long sum(String expression) {
        List<String> num = new ArrayList<>(Arrays.asList(expression.split("[^0-9]")));
        List<String> operation = new ArrayList<>(Arrays.asList(expression.split("[0-9]")));
        operation.removeIf(String::isEmpty);
        System.out.println(permutation);
        System.out.println(num);
        System.out.println(operation);

        try {
            for (char priority : permutation) {
                int idx = 0;
                while (idx < operation.size()) {
                    if (operation.get(idx).equals(priority + "")) {
                        long num1 = Long.parseLong(num.get(idx));
                        long num2 = Long.parseLong(num.get(idx + 1));
                        long sum = calculate(priority, num1, num2);

                        num.set(idx, String.valueOf(sum));
                        num.remove(idx + 1);
                        operation.remove(idx);

                        idx--;
                    }

                    idx++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Long.parseLong(num.get(0));
    }

    public long calculate(char operation, long num1, long num2) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> Long.MIN_VALUE;
        };
    }
}