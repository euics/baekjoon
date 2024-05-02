import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> heap = new ArrayList<>();
        
        for(String operation : operations) {
            String order = operation.split(" ")[0];
            
            switch(order) {
                case "I":
                    heap.add(Integer.parseInt(operation.split(" ")[1]));
                    break;
                case "D":
                    if(heap.size() != 0) {
                        if(Integer.parseInt(operation.split(" ")[1]) == 1) heap.remove(heap.size() - 1);
                        else heap.remove(0);
                        
                        break;
                    }
            }
            
            Collections.sort(heap);
        }
        
        return heap.size() == 0 ? new int[]{0, 0} : new int[]{heap.get(heap.size() - 1), heap.get(0)};
    }
}