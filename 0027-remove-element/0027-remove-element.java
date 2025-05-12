class Solution {
    public int removeElement(int[] nums, int val) {
        int writeIndex = 0;  // Pointer to place elements that are not equal to `val`

        // Iterate over each element in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[writeIndex] = nums[i];  // Place the non-val element at `writeIndex`
                writeIndex++;  // Increment the writeIndex for the next valid element
            }
        }

        // Return the count of elements that are not equal to `val`
        return writeIndex;
    }
}
