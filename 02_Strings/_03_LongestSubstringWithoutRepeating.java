public class _03_LongestSubstringWithoutRepeating {
    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s){
        int[] freq = new int[256];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freq[ch]++;

            // If duplicate, we shrink the window
            while (freq[ch] > 1){
                freq[s.charAt(left)]--;
                left++;
            }

            // Update max substring length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
