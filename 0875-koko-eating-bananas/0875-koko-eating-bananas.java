class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find the maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            // Calculate hours required at speed mid
            for (int pile : piles) {

                // Ceiling division
               // hours += (pile + (long) mid - 1) / mid;
                hours+=(int)Math.ceil((double)pile/mid);
            }

            if (hours <= h) {

                // Speed works; try a smaller speed
                ans = mid;
                high = mid - 1;

            } else {

                // Speed is too slow; increase it
                low = mid + 1;
            }
        }

        return ans;
    }
}