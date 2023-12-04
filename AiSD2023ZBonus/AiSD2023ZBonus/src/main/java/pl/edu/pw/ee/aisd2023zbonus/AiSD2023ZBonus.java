package pl.edu.pw.ee.aisd2023zbonus;

public class AiSD2023ZBonus {

    public int count (String text) {

        int count = 0;
        if (text.length() > 9_999) {
            return -1;
        }

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String littleString = text.substring(i, j);
                if (littleString.length() > 1)
                    if(isPalindrome(littleString)) {
                        count++;
                }
            }
        }
        if (count < 99_999)
            return count;
        else {
            return -1;
        }
    }

    private boolean isPalindrome(String littleString) {
        int left = 0;
        int right = littleString.length() - 1;

        while (left < right) {
            if (littleString.charAt(left) != littleString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


