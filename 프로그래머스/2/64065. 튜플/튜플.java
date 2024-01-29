import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] str = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(str, (a, b) -> a.length() - b.length());

        List<Integer> answer = new ArrayList<>();
        for (String tmp : str) {
            String[] a = tmp.split(",");

            for(String num : a){
                if(!answer.contains(Integer.parseInt(num))) answer.add(Integer.parseInt(num));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}