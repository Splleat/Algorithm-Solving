import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for (String number : phone_book) {
            set.add(number);
        }
        
        for (String number : phone_book) {
            for (int i = 0; i < number.length() - 1; i++) {
                if (set.contains(number.substring(0, i + 1))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}