public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;  // no zigzag needed
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // Change direction at top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        
        // Combine all rows into one string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
    
    // Optional main for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convert("PAYPALISHIRING", 3));  // Output: "PAHNAPLSIIGYIR"
        System.out.println(sol.convert("PAYPALISHIRING", 4));  // Output: "PINALSIGYAHRPI"
        System.out.println(sol.convert("A", 1));               // Output: "A"
    }
}
