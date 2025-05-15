public class Solution {
    public int strStr(String haystack, String needle) {
        // If needle is empty, return 0 by definition
        if (needle.length() == 0) return 0;

        // Use built-in method indexOf, which does exactly what we want
        return haystack.indexOf(needle);
    }

    // Optional main for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strStr("sadbutsad", "sad"));   // Output: 0
        System.out.println(sol.strStr("leetcode", "leeto"));  // Output: -1
    }
}
