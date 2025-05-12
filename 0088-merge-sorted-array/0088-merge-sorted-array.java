class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of both nums1 and nums2
        int i = m - 1; // pointer for nums1's elements
        int j = n - 1; // pointer for nums2's elements
        int k = m + n - 1; // pointer for the last position in nums1

        // Merge the arrays by comparing the elements from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        // No need to worry about remaining elements in nums1 because they are already in place
    }
}
