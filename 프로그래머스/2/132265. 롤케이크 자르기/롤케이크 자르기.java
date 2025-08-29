import java.util.*;

class Solution {
    static int ans = 0;

    public int solution(int[] toppings) {
        Map<Integer, Integer> front = new HashMap<>();
        Map<Integer, Integer> rear = new HashMap<>();
        for (int topping : toppings) rear.put(topping, rear.getOrDefault(topping, 0) + 1);

        for (int i = 0; i < toppings.length; i++) {
            if (front.size() == rear.size()) ans++;

            front.put(toppings[i], front.getOrDefault(toppings[i], 0) + 1);
            rear.put(toppings[i], rear.get(toppings[i]) - 1);
            if (rear.get(toppings[i]) == 0) rear.remove(toppings[i]);
        }

        return ans;
    }
}