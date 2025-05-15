public class Solution {
    public String reverseWords(String s) {
        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        // Use StringBuilder to efficiently build reversed string
        StringBuilder reversed = new StringBuilder();
        
        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }

    // Optional main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("the sky is blue"));            // Output: "blue is sky the"
        System.out.println(sol.reverseWords("  hello world  "));            // Output: "world hello"
        System.out.println(sol.reverseWords("a good   example"));           // Output: "example good a"
    }
}
