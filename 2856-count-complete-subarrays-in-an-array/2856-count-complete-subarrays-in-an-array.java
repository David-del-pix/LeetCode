import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> fullSet = new HashSet<>();
        for (int num : nums) {
            fullSet.add(num);
        }
        int totalDistinct = fullSet.size();
        
        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> windowSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                windowSet.add(nums[j]);
                if (windowSet.size() == totalDistinct) {
                    count++;
                }
            }
        }

        return count;
    }
}
