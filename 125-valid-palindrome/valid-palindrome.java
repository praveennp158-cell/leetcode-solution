import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        List<Character> characters = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                characters.add(Character.toLowerCase(current));
            }
        }

        return helper(characters, 0, characters.size() - 1);
    }

    private boolean helper(List<Character> characters, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (!characters.get(left).equals(characters.get(right))) {
            return false;
        }

        return helper(characters, left + 1, right - 1);
    }
}