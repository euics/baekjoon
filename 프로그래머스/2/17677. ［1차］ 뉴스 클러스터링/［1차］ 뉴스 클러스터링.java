import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> multiSet1 = makeMultiSet(str1);
        List<String> multiSet2 = makeMultiSet(str2);

        if (multiSet1.size() == 0 && multiSet2.size() == 0) return 65536;

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>(multiSet1);

        for(String str : multiSet2){
            if(multiSet1.contains(str)){
                intersection.add(str);
                multiSet1.remove(str);
            } else {
                union.add(str);
            }
        }

        return (int) (((float) intersection.size() / (float) union.size()) * 65536);
    }

    public List<String> makeMultiSet(String str) {
        List<String> multiSet = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);

            if (Character.isLetter(first) && Character.isLetter(second))
                multiSet.add((first + "" + second).toUpperCase());
        }

        return multiSet;
    }
}