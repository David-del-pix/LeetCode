import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array first

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // Example to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {-1,0,1,2,-1,-4};
        System.out.println(sol.threeSum(nums1)); // Output: [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0,1,1};
        System.out.println(sol.threeSum(nums2)); // Output: []

        int[] nums3 = {0,0,0};
        System.out.println(sol.threeSum(nums3)); // Output: [[0, 0, 0]]
    }
}
