class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        // Use <= because the target might be at the exact left or right pointer
        while (left <= right) {
            
            // Safe way to find the middle to prevent integer overflow
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // We found it!
            } 
            else if (nums[mid] < target) {
                // The middle number is too small, so ignore the left half
                left = mid + 1;
            } 
            else {
                // The middle number is too big, so ignore the right half
                right = mid - 1;
            }
        }
        
        // We shrank the window to nothing and didn't find it
        return -1;
    }
}