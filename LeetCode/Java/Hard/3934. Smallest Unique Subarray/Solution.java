import java.util.*;

class Solution {
    int max;
    int n;
    int ans;

    public boolean check(int size, int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();

        long num = 0;
        long power = 1;

        for (int i = 0; i < size; i++) {
            num = num * max + nums[i];
            power *= max;
        }

        map.put(num, 1);

        for (int i = size; i < n; i++) {
            num = num - (long) nums[i - size] * (power / max);
            num = num * max + nums[i];

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Long k : map.keySet()) {
            if (map.get(k) == 1)
                return true;
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {
        this.n = nums.length;
        this.max = 0;
        this.ans = n;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        max++;

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(mid, nums)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}