class Solution {
    int n;
    int m;

    public int solve(int i, int j, int[][] grid) {

        if(j < 0 || j >= m) return -1;

        if(i == n) return j;

        if(grid[i][j] == 1) {
            if(j+1 >= m || grid[i][j+1] == -1) {
                return -1;
            }

            return solve(i+1, j+1, grid);
        } 
        else {
            if(j-1 < 0 || grid[i][j-1] == 1) {
                return -1;
            }

            return solve(i+1, j-1, grid);
        }
    }

    public int[] findBall(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int[] ans = new int[m];

        for(int j = 0; j < m; j++) {
            ans[j] = solve(0, j, grid);
        }

        return ans;
    }
}