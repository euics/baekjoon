class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skill_tree : skill_trees) {
            boolean bool = true;
            int lastIndex = -1;

            for(int i = 0; i < skill_tree.length(); i++) {
                char cur = skill_tree.charAt(i);
                int index = skill.indexOf(cur);

                if(index == -1) continue;

                if(index != lastIndex + 1) {
                    bool = false;
                    break;
                }

                lastIndex = index;
            }

            if (bool) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("CBD", new String[]{"BACDE", "CBADF", "AECD", "BDA"}));
    }
}