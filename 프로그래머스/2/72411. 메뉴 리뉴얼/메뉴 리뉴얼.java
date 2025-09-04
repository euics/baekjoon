import java.util.*;

class Solution {
    static List<String> ans = new ArrayList<>();
    static Map<String, Integer> candidate = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        Set<Character> set = new HashSet<>();
        for (String order : orders) for (int i = 0; i < order.length(); i++) set.add(order.charAt(i));

        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            map.putIfAbsent(i, new ArrayList<Character>());
            for (int j = 0; j < orders[i].length(); j++) {
                map.get(i).add(orders[i].charAt(j));
            }
        }

        char[] menu = new char[set.size()];
        int idx = 0;
        for (char ch : set) menu[idx++] = ch;
        Arrays.sort(menu);

        for (int i = 0; i < course.length; i++) {
            int length = course[i];
            char[] combination = new char[length];
            combination(0, length, 0, menu, map, combination);
        }

        List<String> key = new LinkedList<>(candidate.keySet());
        Collections.sort(key, (a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();

            return candidate.get(b) - candidate.get(a);
        });

        for (int i = 0; i < course.length; i++) {
            int length = course[i];
            int max = Integer.MIN_VALUE;

            for (String k : key) {
                if (k.length() == length) {
                    max = Math.max(max, candidate.get(k));
                }
            }

            for (String k : key) {
                if (k.length() == length && max == candidate.get(k)) {
                    ans.add(k);
                }
            }
        }

        Collections.sort(ans);

        return ans.stream().toArray(String[]::new);
    }

    public void combination(int L, int length, int s, char[] menu, Map<Integer, List<Character>> map, char[] combination) {
        if (L == length) {
            int count = count(map, combination);
            if (count >= 2) candidate.put(String.valueOf(combination), count);

            return;
        }

        for (int i = s; i < menu.length; i++) {
            combination[L] = menu[i];
            combination(L + 1, length, i + 1, menu, map, combination);
        }
    }

    public int count(Map<Integer, List<Character>> map, char[] combination) {
        int cnt = 0;

        for (int key : map.keySet()) {
            boolean bool = true;

            for (int i = 0; i < combination.length; i++) {
                if (!map.get(key).contains(combination[i])) {
                    bool = false;
                    break;
                }
            }

            if (bool) cnt++;
        }

        return cnt;
    }
}