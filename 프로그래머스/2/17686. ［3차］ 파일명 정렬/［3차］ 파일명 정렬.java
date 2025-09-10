import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                if (!head1.equalsIgnoreCase(head2)) {
                    return head1.toUpperCase().compareTo(head2.toUpperCase());
                }

                int num1 = Integer.parseInt(o1.replaceAll("[^0-9]", " ").trim().split(" ")[0]);
                int num2 = Integer.parseInt(o2.replaceAll("[^0-9]", " ").trim().split(" ")[0]);

                return num1 - num2;
            }
        });

        return files;
    }
}