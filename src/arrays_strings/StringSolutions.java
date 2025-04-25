package arrays_strings;

public class StringSolutions {


    /**
     * LeetCode 344 - Reverse String
     *
     * Time:
     * Space:
     *
     * Approach:
     * Use Two pointers to iterate the char array:
     * - reverse the char array in place without an extra memory space (better space complexity)
     * - only iterate the array once, avoid accessing the element multiple times (better time complexity)
     * - minimizes the risk of making errors related to array boundaries
     */
    void reverseString(char[] s) {

        if ( null == s || s.length == 0)
            return;

        int headIdx = 0;
        int tailIdx = s.length - 1;

        while(headIdx < tailIdx) {

            char tmp = s[headIdx];
            s[headIdx] = s[tailIdx];
            s[tailIdx] = tmp;

            headIdx ++;
            tailIdx --;

        }
    }

    /**
     * LeetCode 242 - Valid Anagram
     *
     * Time:
     * Space:
     *
     * Approach:
     */
    public boolean isAnagram(String s, String t){

        if (s.length() != t.length())
            return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {

            -- count[t.charAt(i) - 'a'];
            //stop if count minor than 0
            if(count[t.charAt(i) - 'a'] < 0)
                return false;
        }

        return true;
    }

    /**
     * LeetCode 14 - Longest Common Prefix
     *
     * Time:
     * Space:
     *
     * Approach:
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (String str : strs) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;

    }


    /**
     * LeetCode 14 - Longest Common Prefix
     *
     * Time:
     * Space:
     *
     * Approach:
     * */
    public String longestCommonPrefix2(String[] strs) {

        String prefix = strs[0];

        for (int prefixIdx = 0; prefixIdx < prefix.length(); prefixIdx++) {
            char currentPrefixChar = prefix.charAt(prefixIdx);

            for (int i = 1; i < strs.length; i++) {
                String currentString = strs[i];

                if (prefixIdx >= currentString.length() || currentString.charAt(prefixIdx) != currentPrefixChar){
                    return prefix.substring(0, prefixIdx);
                }
            }
        }

        return prefix;
    }

    // Test
    public static void main(String[] args) {
        ArraySolutions sol = new ArraySolutions();


    }
}
