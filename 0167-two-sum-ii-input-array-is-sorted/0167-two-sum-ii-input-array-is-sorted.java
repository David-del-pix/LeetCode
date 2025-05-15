public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // Since there is exactly one solution, this return won't be reached.
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] result1 = sol.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]"); // [1, 2]

        int[] result2 = sol.twoSum(new int[]{2,3,4}, 6);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]"); // [1, 3]

        int[] result3 = sol.twoSum(new int[]{-1,0}, -1);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]"); // [1, 2]
    }
}
