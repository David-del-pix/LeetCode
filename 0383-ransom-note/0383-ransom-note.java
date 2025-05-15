public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26]; // For lowercase letters only

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) return false;
            count[c - 'a']--;
        }

        return true;
    }
}
