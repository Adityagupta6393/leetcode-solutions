class Solution {
    int m;
    int n;
    int[][][] memo;
    int MOD = 1000000007;
    public int solve(int i, int j, int prev, int[][] grid){
        if(i==m-1 && j==n-1) return 1;

        if(i>=m || j>=n) return 0;

        if(memo[i][j][prev] != -1) return memo[i][j][prev];

        int right = 0;
        int down = 0;
        if(grid[i][j]==1){
            if(prev==0) down = solve(i+1, j, 1, grid);
            if(prev==1) right = solve(i, j+1, 0,grid);
        }else{
            right = solve(i, j+1 , 0, grid);
            down = solve(i+1, j, 1, grid);
        }
        return memo[i][j][prev] = (right + down) % MOD;
    }
    public int uniquePaths(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        memo = new int[m][n][2];
        for(int i=0; i<m; i++){
           for(int j=0; j<n; j++){
                Arrays.fill(memo[i][j], -1);
           }
        }
        return solve(0, 0, 0, grid);

    }
}