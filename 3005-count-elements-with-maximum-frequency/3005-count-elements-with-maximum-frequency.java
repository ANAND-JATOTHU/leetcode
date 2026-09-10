class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        
        for (int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }
        
        int totalCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                totalCount += count;
            }
        }
        
        return totalCount;
    }
}