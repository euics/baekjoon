class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skill_tree : skill_trees) {
            int skillIndex = 0;
            boolean bool = true;

            for(int i = 0; i < skill_tree.length(); i++) {
                int index = skill.indexOf(skill_tree.charAt(i));

                if(index == -1) continue;

                if(index != skillIndex) {
                    bool = false;
                    break;
                }

                skillIndex = index + 1;
            }

            if(bool) answer++;
        }

        return answer;
    }
}