class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize with a base value to calculate valid substring lengths.
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(i); // Push index of '(' onto the stack.
            } else {
                stack.pop(); // Pop the last unmatched '(' or base value
                
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek()); // Calculate valid substring length
                } else {
                    stack.push(i); // Push the current index as base if no matching '('
                }
            }
        }
        
        return maxLength;
    }
}
