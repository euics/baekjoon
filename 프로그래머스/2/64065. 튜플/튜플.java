import java.util.*;

class Solution {
    static List<Integer> ans = new ArrayList<>();

    public int[] solution(String s) {
        String[] words = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String[] word = words[i].split(",");

            for (int j = 0; j < word.length; j++) {
                int number = Integer.parseInt(word[j]);
                if (!set.contains(number)) {
                    ans.add(number);
                    set.add(number);
                }
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}