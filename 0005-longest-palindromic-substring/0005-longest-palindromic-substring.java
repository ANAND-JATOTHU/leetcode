class Solution {
    public String longestPalindrome(String s) {
        int st = 0;
        int mx = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {

                if (r - l + 1 > mx) {
                    mx = r - l + 1;
                    st = l;
                }

                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {

                if (r - l + 1 > mx) {
                    mx = r - l + 1;
                    st = l;
                }

                l--;
                r++;
            }
        }

        return s.substring(st, st + mx);
    }
}