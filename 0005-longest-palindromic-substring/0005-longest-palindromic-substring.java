class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String lps = "";
        int l, h;

        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome
            l = i;
            h = i;

            while (l >= 0 && h < s.length()
                    && s.charAt(l) == s.charAt(h)) {

                String palindrome = s.substring(l, h + 1);

                if (palindrome.length() > lps.length()) {
                    lps = palindrome;
                }

                l--;
                h++;
            }

            // Even-length palindrome
            l = i - 1;
            h = i;

            while (l >= 0 && h < s.length()
                    && s.charAt(l) == s.charAt(h)) {

                String palindrome = s.substring(l, h + 1);

                if (palindrome.length() > lps.length()) {
                    lps = palindrome;
                }

                l--;
                h++;
            }
        }

        return lps;
    }
}