import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        boolean bool = true;

        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) {
                bool = false;
                break;
            }
        }

        return bool;
    }
}