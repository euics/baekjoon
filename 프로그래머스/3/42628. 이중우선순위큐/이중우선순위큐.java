import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < operations.length; i++) {
            String order = operations[i].split(" ")[0];

            switch (order) {
                case "I":
                    int num = Integer.parseInt(operations[i].split(" ")[1]);
                    maxHeap.add(num);
                    minHeap.add(num);
                    break;
                case "D":
                    int x = Integer.parseInt(operations[i].split(" ")[1]);
                    if(x == 1) {
                        if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                            int max = maxHeap.poll();
                            minHeap.remove(max);
                        }
                    } else if(x == -1){
                        if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                            int min = minHeap.poll();
                            maxHeap.remove(min);
                        }
                    }
                    break;
            }
        }

        if(maxHeap.isEmpty() && minHeap.isEmpty()) return new int[]{0, 0};
        else return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}