import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] number = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) number[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(number, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length; i++) sb.append(number[i]);
        
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}