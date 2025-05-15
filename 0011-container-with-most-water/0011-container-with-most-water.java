public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate area formed between left and right lines
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;

            // Update max area if current is greater
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(height1));  // Output: 49

        int[] height2 = {1,1};
        System.out.println(sol.maxArea(height2));  // Output: 1
    }
}
