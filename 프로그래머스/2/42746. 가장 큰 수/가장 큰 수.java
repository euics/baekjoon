import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] str = new String[n];
        for(int i = 0; i < n; i++) str[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(str[i]);

        if(sb.toString().startsWith("0")) return "0";
        
        return sb.toString();
    }
}