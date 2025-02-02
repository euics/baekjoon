class Solution {
    static StringBuilder answer = new StringBuilder();
    static String[] dictionary = {
        "zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine"
    };
    
    public int solution(String s) {
        
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                answer.append(s.charAt(i));
            } else {
                StringBuilder sb = new StringBuilder();
                
                while(i < s.length() && Character.isAlphabetic(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    
                    for(int j = 0; j < 10; j++) {
                        if(dictionary[j].matches(sb.toString())) {
                            answer.append(j);
                            sb = new StringBuilder();
                            break;
                        }
                    }
                    
                    i++;
                }
                
                i--;
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
}