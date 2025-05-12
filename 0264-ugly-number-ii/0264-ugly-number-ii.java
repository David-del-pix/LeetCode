class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1; // The first ugly number is 1

        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            int next = Math.min(next2, Math.min(next3, next5));
            ugly[i] = next;

            if (next == next2) {
                i2++;
                next2 = ugly[i2] * 2;
            }
            if (next == next3) {
                i3++;
                next3 = ugly[i3] * 3;
            }
            if (next == next5) {
                i5++;
                next5 = ugly[i5] * 5;
            }
        }

        return ugly[n - 1];
    }
}
