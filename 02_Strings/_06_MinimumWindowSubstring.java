import java.util.*;

public class _06_MinimumWindowSubstring {
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t){
        if (s.length() < t.length()) return "";

        int[] freq = new int[256];
        for (char c : t.toCharArray()){
            freq[c]++;
        }

        int left = 0, right = 0;
        int count = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()){
            char ch = s.charAt(right);

            if (freq[ch] > 0){
                count--;
            }
            freq[ch]--;
            right++;

            // When we found valid window
            while (count == 0){
                // Update answer
                if (right - left < minLength){
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (freq[leftChar] == 0){
                    count++;
                }
                freq[leftChar]++;

                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}