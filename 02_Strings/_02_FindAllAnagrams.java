import java.util.ArrayList;
import java.util.List;

public class _02_FindAllAnagrams {
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = findAllAnagrams(s, p);
        System.out.println(result);
    }

    public static List<Integer> findAllAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;
        int[] arr = new int[26];

        for (int i=0; i<p.length(); i++){
            arr[p.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        int count = p.length();

        while (right < s.length()){
            // Add right Character
            if (arr[s.charAt(right) - 'a'] > 0){
                count--;
            }
            arr[s.charAt(right) - 'a']--;
            right++;

            // When window size equals p
            if (right - left == p.length()){
                // Check Anagram
                if (count == 0){
                    result.add(left);
                }

                // Remove Left Character
                if (arr[s.charAt(left) - 'a'] >= 0){
                    count++;
                }
                arr[s.charAt(left) - 'a']++;

                left++;
            }
        }
        return result;
    }
}
