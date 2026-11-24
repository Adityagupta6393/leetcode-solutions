class Solution {
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int product = 1;
            int gcd = nums[i];
            int lcm = nums[i];

            for (int j = i; j < n; j++) {
                product *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);

                if (product == gcd * lcm)
                    max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }
}