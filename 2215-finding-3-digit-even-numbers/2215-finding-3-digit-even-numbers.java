class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();

        int[] freq = new int[10];
        for (int d : digits) freq[d]++;

        // Try all possible 3-digit numbers from 100 to 998 (even only)
        for (int num = 100; num <= 999; num += 2) {
            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            int[] count = new int[10];
            count[d1]++;
            count[d2]++;
            count[d3]++;

            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (count[i] > freq[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) result.add(num);
        }

        // Convert result set to int[]
        int[] res = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            res[idx++] = num;
        }

        return res;
    }
}
