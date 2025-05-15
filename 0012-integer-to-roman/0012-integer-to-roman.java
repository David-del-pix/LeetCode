public class Solution {
    public String intToRoman(int num) {
        // Arrays of Roman symbols and their corresponding values
        int[] values =    {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,   1};
        String[] symbols ={"M",  "CM","D", "CD","C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        
        return sb.toString();
    }
    
    // Optional: main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.intToRoman(3749));  // Output: MMMDCCXLIX
        System.out.println(sol.intToRoman(58));    // Output: LVIII
        System.out.println(sol.intToRoman(1994));  // Output: MCMXCIV
    }
}
