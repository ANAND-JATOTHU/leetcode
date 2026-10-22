class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int k = -1;
        
        // Find the index of 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                k = i;
                break;
            }
        }
        
        boolean isInc = true;
        boolean isDec = true;
        
        // Check if the array is an Increasing Cyclic Shift
        for (int i = 0; i < n; i++) {
            if (nums[(k + i) % n] != i) {
                isInc = false;
                break;
            }
        }
        
        // Check if the array is a Decreasing Cyclic Shift
        for (int i = 0; i < n; i++) {
            // (k - i + n) % n ensures we safely wrap around the left side
            if (nums[(k - i + n) % n] != i) {
                isDec = false;
                break;
            }
        }
        
        int minOps = Integer.MAX_VALUE;
        
        if (isInc) {
            minOps = Math.min(minOps, k);
            minOps = Math.min(minOps, n - k + 2);
        }
        
        if (isDec) {
            minOps = Math.min(minOps, n - k);
            minOps = Math.min(minOps, k + 2);
        }
        
        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }
}