
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        int[] dp = new int[budget + 1];

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            minPrice = Math.min(minPrice, price);

            int count = 0;

            // Count items whose factors are divisible by this factor
            for (int[] other : items) {
                if (other[0] % factor == 0) {
                    count++;
                }
            }

            // 0/1 Knapsack
            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + count);
            }
        }

        int ans = 0;

        // Spend remaining budget on cheapest items
        for (int i = 0; i <= budget; i++) {
            ans = Math.max(ans, dp[i] + (budget - i) / minPrice);
        }

        return ans;
    }
}
