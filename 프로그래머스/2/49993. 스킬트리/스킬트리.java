import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            int p = 0;
            boolean bool = true;

            for (int j = 0; j < skill_trees[i].length(); j++) {
                int idx = skill.indexOf(skill_trees[i].charAt(j));
                if (idx == -1) continue;

                if (p != idx) {
                    bool = false;
                    break;
                } else {
                    p++;
                }
            }

            if(bool) ans++;
        }

        return ans;
    }
}