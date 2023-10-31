import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < operations.length; i++){
            String type = operations[i].split(" ")[0];
            int data = Integer.parseInt(operations[i].split(" ")[1]);
            
            switch(type) {
                case "I":
                    list.add(data);
                    break;
                case "D":
                    if(!list.isEmpty()){
                        if(data == -1)
                            list.remove(0);
                        else
                            list.remove(list.size() - 1);
                    }
                    
                    break;
            }
            
            Collections.sort(list);
        }
        
        if(list.size() == 0)
            return new int[]{0, 0};
        else
            return new int[]{list.get(list.size() - 1), list.get(0)};
    }
}