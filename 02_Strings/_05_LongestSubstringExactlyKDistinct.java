import java.util.HashMap;
import java.util.Map;

public class _05_LongestSubstringExactlyKDistinct {
    public static void main(String[] args){
        String s = "aaabbcc";
        int k = 2;

        System.out.println(longestSubstringExactlyK(s, k));
    }

    public static int longestSubstringExactlyK(String s, int k){
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink the window if map size becomes > k
            while (map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }

            if (map.size() == k){
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}
