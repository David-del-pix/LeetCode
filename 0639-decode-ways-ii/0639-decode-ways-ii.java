class Solution {
    public int numDecodings(String s) {
        int MOD = 1000000007;
        long prev = 1, curr = ways(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i), p = s.charAt(i - 1);
            long next = (curr * ways(c)) % MOD;
            next = (next + (prev * pairWays(p, c)) % MOD) % MOD;
            prev = curr;
            curr = next;
        }
        return (int) curr;
    }

    private int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }

    private int pairWays(char first, char second) {
        if (first == '*' && second == '*') return 15; // 11–19 + 21–26
        if (first == '*') {
            if (second <= '6') return 2; // 1x and 2x
            return 1; // only 1x
        }
        if (second == '*') {
            if (first == '1') return 9;
            if (first == '2') return 6;
            return 0;
        }
        int num = (first - '0') * 10 + (second - '0');
        return (num >= 10 && num <= 26) ? 1 : 0;
    }
}
