import java.util.*;

class Solution {
    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                operations.add(ch);
                numbers.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            }
        }
        numbers.add(Long.parseLong(sb.toString()));

        char[] oper = new char[]{'+', '-', '*'};
        char[] sequences = new char[3];
        permutation(0, oper, sequences, new boolean[3], numbers, operations);

        return max;
    }

    static long max = Long.MIN_VALUE;

    public void permutation(int L, char[] oper, char[] sequences, boolean[] bool, List<Long> numbers, List<Character> operations) {
        if (L == 3) {
            max = Math.max(max, Math.abs(calculate(numbers, operations, sequences)));

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!bool[i]) {
                bool[i] = true;
                sequences[L] = oper[i];
                permutation(L + 1, oper, sequences, bool, numbers, operations);
                bool[i] = false;
            }
        }
    }


    private long calculate(List<Long> numbers, List<Character> operations, char[] sequences) {
        LinkedList<Long> numList = new LinkedList<>(numbers);
        LinkedList<Character> opList = new LinkedList<>(operations);

        for (char sequence : sequences) {
            for (int i = 0; i < opList.size(); i++) {
                if (opList.get(i) == sequence) {
                    long result = applyOperation(numList.remove(i), numList.remove(i), opList.remove(i));
                    numList.add(i, result);
                    i--;
                }
            }
        }
        return numList.get(0);
    }

    private long applyOperation(long a, long b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }
}