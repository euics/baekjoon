import java.util.*;

class Solution {
    static ArrayList<Set<Integer>> candidates = new ArrayList<>();

    public int solution(String[][] relation) {
        for (int length = 1; length <= relation[0].length; length++) {
            combination(0, length, 0, relation[0].length, relation, new int[length]);
        }

        return candidates.size();
    }

    public void combination(int L, int depth, int s, int n, String[][] relation, int[] combination) {
        if (L == depth) {
            if (uniqueness(relation, combination)) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < combination.length; i++) {
                    set.add(combination[i]);
                }

                for (Set<Integer> candidate : candidates) {
                    if (set.containsAll(candidate)) {
                        return;
                    }
                }

                candidates.add(new HashSet<>(set));
            }

            return;
        }

        for (int i = s; i < n; i++) {
            combination[L] = i;
            combination(L + 1, depth, i + 1, n, relation, combination);
        }
    }

    public boolean uniqueness(String[][] relation, int[] combination) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < combination.length; j++) {
                sb.append(relation[i][combination[j]]);
            }

            set.add(sb.toString());
        }

        return set.size() == relation.length;
    }
}