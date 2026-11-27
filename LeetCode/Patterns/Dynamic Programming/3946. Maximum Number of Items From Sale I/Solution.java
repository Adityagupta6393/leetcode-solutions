class Solution {
    int n;
    HashMap<Integer, Integer> map;
    int cheapestItem = 1501;

    public int solve(int i, int budget, int[][] items){
        if(i==n) return budget/cheapestItem;

        int buy = 0;
        if(budget >= items[i][1]){
            buy = 1 + map.getOrDefault(items[i][0], 0) + solve(i+1, budget - items[i][1], items);
        }
        // if(!boughtOnce[i] && map.containsKey(items[i][0])) buy += map.get(items[i][0]);
        // boughtOnce[i] = true;
        // buy = 1 + solve(i, budget - items[i][1] , boughtOnce, items);
        // boughtOnce[i] = false;
        // if(boughtOnce[i]){
        //     buy = 1 + solve(i, budget - items[i][1], boughtOnce, items);
        // }else{
        //     boughOnce[i] = true;
        //     buy = 1 + map.get(items[i][0]) + solve(i, budget - items[i][1], boughtOnce, items);
        //     boughtOnce[i] = false;
        // }

        int skip = solve(i+1, budget, items);

        return Math.max(buy, skip);
    }

    public int maximumSaleItems(int[][] items, int budget) {
        this.n = items.length;
        this.map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cheapestItem = Math.min(cheapestItem, items[i][1]);
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0)
                    map.put(items[i][0], map.getOrDefault(items[i][0], 0) + 1);
            }
        }

        return solve(0, budget, items);
    }
}