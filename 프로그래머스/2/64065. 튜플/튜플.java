import java.util.*;

class Solution {

    public int[] solution(String s) {
        String[] strs = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        Set<String> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for (String str : strs) {
            for (String splitNum : str.split(",")) {
                if (!set.contains(splitNum)) {
                    set.add(splitNum);
                    answer.add(Integer.parseInt(splitNum));
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}