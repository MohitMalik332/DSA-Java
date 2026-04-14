/*
Question: Valid Anagram

Approach:
- Use frequency array of size 256
- Increment for string s
- Decrement for string t
- If all values are 0 → anagram

Pattern:
Frequency Counter

How to remember:
- “Balance counts → ++ and --”

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class _01_ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println("Result: " + isAnagram(s, t));
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr = new int[26];
        for (int i=0; i<s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr){
            if (i != 0) return false;
        }

        return true;
    }
}
