import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) str[i] = String.valueOf(numbers[i]);

        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++) sb.append(str[i]);

        if(sb.toString().startsWith("0")) return "0";
        else return sb.toString();
    }
}