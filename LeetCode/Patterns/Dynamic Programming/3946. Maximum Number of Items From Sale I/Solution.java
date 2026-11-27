class Solution {
    int n;
    HashMap<Integer, Integer> map;
    int cheapestItem = 1501;
    int[][] dp;

    public int solve(int i, int budget, int[][] items) {
        if (i == n)
            return budget / cheapestItem;

        if (dp[i][budget] != -1)
            return dp[i][budget];

        int buy = 0;

        if (budget >= items[i][1]) {
            buy = 1 + map.getOrDefault(items[i][0], 0)
                    + solve(i + 1, budget - items[i][1], items);
        }

        int skip = solve(i + 1, budget, items);

        return dp[i][budget] = Math.max(buy, skip);
    }

    public int maximumSaleItems(int[][] items, int budget) {
        this.n = items.length;
        this.map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cheapestItem = Math.min(cheapestItem, items[i][1]);

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    map.put(items[i][0],
                            map.getOrDefault(items[i][0], 0) + 1);
                }
            }
        }

        dp = new int[n][budget + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, budget, items);
    }
}