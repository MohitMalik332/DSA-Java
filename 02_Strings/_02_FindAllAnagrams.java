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

        for (int i=0; i<=s.length() - p.length(); i++){
            String str = s.substring(i, i+p.length());
            int[] arr = new int[26];

            for (int j=0; j<p.length(); j++){
                arr[str.charAt(j) - 'a']++;
                arr[p.charAt(j) - 'a']--;
            }

            boolean isAnagram = true;

            for (int a : arr){
                if (a != 0){
                    isAnagram = false;
                    break;
                }
            }

            if (isAnagram){
                result.add(i);
            }

        }
        return result;
    }
}
