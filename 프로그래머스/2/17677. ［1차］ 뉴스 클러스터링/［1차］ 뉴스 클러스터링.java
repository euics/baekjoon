import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> A = convert(str1);
        List<String> B = convert(str2);

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>(A);

        for (String str : B) {
            if (A.contains(str)) {
                intersection.add(str);
                A.remove(str);
            } else {
                union.add(str);
            }
        }

        return union.isEmpty() ? 65536 : (int) (((float) intersection.size() / (float) union.size()) * 65536);
    }

    public List<String> convert(String str) {
        List<String> union = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            if (Character.isAlphabetic(first) && Character.isAlphabetic(second))
                union.add((first + "" + second).toUpperCase());
        }

        return union;
    }
}