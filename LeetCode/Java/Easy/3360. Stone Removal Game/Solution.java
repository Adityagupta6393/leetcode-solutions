class Solution {
    public boolean canAliceWin(int n) {
        boolean ans = false;
        for(int i=10; i>=1; i--){
            if(n >= i){
                n -= i;
            }else{
                if(i%2!=0){
                    ans = true;
                }
                break;
            }
        }

        return ans;
    }
}