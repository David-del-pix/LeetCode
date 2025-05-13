class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        long[] freq = new long[26];

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Simulate t transformations
        for (int i = 0; i < t; i++) {
            long[] next = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) { // 'z'
                    next[0] = (next[0] + freq[j]) % MOD; // add to 'a'
                    next[1] = (next[1] + freq[j]) % MOD; // add to 'b'
                } else {
                    next[j + 1] = (next[j + 1] + freq[j]) % MOD;
                }
            }
            freq = next;
        }

        // Step 3: Sum the frequency array to get total characters
        long total = 0;
        for (int i = 0; i < 26; i++) {
            total = (total + freq[i]) % MOD;
        }

        return (int) total;
    }
}
