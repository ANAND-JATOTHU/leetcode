class Solution {
    public int sortPermutation(int[] nums) {
        
        int k = -1;
        boolean isSorted = true;
        
        for (int i = 0; i < nums.length; i++) {
            // If the element is out of place
            if (nums[i] != i) {
                isSorted = false;
                
                // Initialize k with the first misplaced element, or AND it with the rest
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }
        
        // The problem states that if the array is already sorted, we should return 0
        return isSorted ? 0 : k;
    }
}
    