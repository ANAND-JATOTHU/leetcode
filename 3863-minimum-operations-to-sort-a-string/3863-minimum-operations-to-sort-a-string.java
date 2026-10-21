class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // 1. Is it already sorted?
        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;
        
        // 2. Impossible edge case
        if (n == 2) return -1;
        
        // 3. Precompute max and min values for Prefix and Suffix
        char minSuffix = s.charAt(1);
        char maxSuffix = s.charAt(1);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < minSuffix) minSuffix = s.charAt(i);
            if (s.charAt(i) > maxSuffix) maxSuffix = s.charAt(i);
        }
        
        char minPrefix = s.charAt(0);
        char maxPrefix = s.charAt(0);
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) < minPrefix) minPrefix = s.charAt(i);
            if (s.charAt(i) > maxPrefix) maxPrefix = s.charAt(i);
        }
        
        // 4. Can we do it in 1 Operation?
        // Sort Suffix (leaving s[0] untouched) OR Sort Prefix (leaving s[n-1] untouched)
        if (s.charAt(0) <= minSuffix || s.charAt(n - 1) >= maxPrefix) {
            return 1;
        }
        
        // 5. Can we do it in 2 Operations?
        // Prefix -> Suffix OR Suffix -> Prefix
        if (minPrefix <= s.charAt(n - 1) || s.charAt(0) <= maxSuffix) {
            return 2;
        }
        
        // 6. 3 Operations is mathematically guaranteed for any string n >= 3
        return 3;
    }
}