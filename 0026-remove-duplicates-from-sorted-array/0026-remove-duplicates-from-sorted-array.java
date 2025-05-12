class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;  // If the array is empty, there are no unique elements
        }

        int k = 1;  // Pointer to place the next unique element

        // Iterate over the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];  // Place the unique element at the correct position
                k++;  // Increment k to indicate the next position for unique element
            }
        }

        // Return the count of unique elements
        return k;
    }
}
