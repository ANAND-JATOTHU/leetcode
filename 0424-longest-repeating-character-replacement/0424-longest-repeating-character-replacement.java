class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0; 
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            freq[rightChar - 'A']++;
            
            maxFreq = Math.max(maxFreq, freq[rightChar - 'A']);
            
            int windowSize = right - left + 1;
            if (windowSize - maxFreq > k) {
                
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++; 
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}