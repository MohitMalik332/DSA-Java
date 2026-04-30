public class _07_ValidPalindrome {
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            // skip invalid chars on left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            // skip invalid chars on right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            // compare the valid characters
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
