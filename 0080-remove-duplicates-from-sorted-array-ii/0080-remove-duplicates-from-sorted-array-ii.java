class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;  // If the array is empty, no need to process
        }

        int k = 1;  // Pointer to track where the next valid element should be placed
        int count = 1;  // Count of occurrences of the current element

        // Start iterating from the second element (index 1)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;  // Increment count if the current element is the same as the previous one
            } else {
                count = 1;  // Reset count if we encounter a new element
            }

            // If the current element appears at most twice, place it at position k
            if (count <= 2) {
                nums[k] = nums[i];
                k++;  // Increment k to point to the next position
            }
        }

        return k;  // Return the number of valid elements
    }
}
