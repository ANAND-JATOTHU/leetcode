class Solution {
    public int countRotations(String s, int k) {
        int n = s.length(), c = 0, res = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt((i + 1) % n)) c++;
        }
        
        for (int i = 0; i < n; i++) {
            int drop = s.charAt((i - 1 + n) % n) == s.charAt(i) ? 1 : 0;
            if (c - drop == k) res++;
        }
        
        return res;
    }
}