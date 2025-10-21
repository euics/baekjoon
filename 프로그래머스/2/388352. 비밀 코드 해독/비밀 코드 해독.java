import java.util.*;

class Solution {
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    public int solution(int n, int[][] q, int[] ans) {
        combination(n, 0, q[0].length, 1, new ArrayList<Integer>());

        for (int i = 0; i < results.size(); i++) {
            Collections.sort(results.get(i));

            boolean bool = true;
            for (int j = 0; j < q.length; j++) {
                int cnt = 0;

                for (int k = 0; k < q[j].length; k++) {
                    if (results.get(i).contains(q[j][k])) {
                        cnt++;
                    }
                }

                if (ans[j] != cnt) {
                    bool = false;
                    break;
                }
            }

            if (bool) answer++;
        }

        return answer;
    }

    public void combination(int n, int L, int depth, int s, ArrayList<Integer> result) {
        if (L == depth) {
            results.add(new ArrayList<>(result));

            return;
        }

        for (int i = s; i <= n; i++) {
            result.add(i);
            combination(n, L + 1, depth, i + 1, result);
            result.remove(result.size() - 1);
        }
    }
}