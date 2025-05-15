public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;
        int sLen = s.length(), tLen = t.length();

        while (sIndex < sLen && tIndex < tLen) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == sLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(sol.isSubsequence("axc", "ahbgdc")); // false
    }
}
