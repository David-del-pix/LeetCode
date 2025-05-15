public class Solution {
    public int lengthOfLastWord(String s) {
        // Trim trailing spaces
        s = s.trim();
        
        // Find the last space index
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // Length of last word = total length - last space position - 1
        return s.length() - lastSpaceIndex - 1;
    }

    // Optional main method for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.lengthOfLastWord("Hello World"));           // Output: 5
        System.out.println(sol.lengthOfLastWord("   fly me   to   the moon  ")); // Output: 4
        System.out.println(sol.lengthOfLastWord("luffy is still joyboy")); // Output: 6
    }
}
