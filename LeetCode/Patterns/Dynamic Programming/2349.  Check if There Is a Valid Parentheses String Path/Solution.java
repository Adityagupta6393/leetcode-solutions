class Solution {
    Boolean[][][] dp;
    public boolean solve(int row, int col, int balance, char[][] grid){
        if(row == grid.length-1 && col == grid[0].length-1){
            if(grid[row][col] == '('){
                balance++;
            }else{
                balance--;
            }
            return balance==0;
        }

        if(row >= grid.length || col >= grid[0].length) return false;

        if(dp[row][col][balance] != null) return dp[row][col][balance]; 
        boolean down = false;
        boolean right = false;

        //if current element is open bracket
        if(grid[row][col] == '('){
            down = solve(row + 1, col, balance + 1, grid);
            right = solve(row, col + 1, balance + 1, grid);
        }
        
        //if current element if close bracket then we can proceed further only when no.of open brackets are greater than close
        if(grid[row][col] == ')' && balance > 0){
            down = solve(row + 1, col, balance - 1, grid);
            right = solve(row, col + 1, balance - 1, grid);
        }

        //If any of way got true return true
        return dp[row][col][balance] = down || right;
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int size = m + n;

        dp = new Boolean[size][size][size];

        return solve(0, 0, 0, grid);
    }
}