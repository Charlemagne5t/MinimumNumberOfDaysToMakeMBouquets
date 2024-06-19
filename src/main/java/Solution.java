public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 0;
        int r = (int) 1e9 + 1;
        int mid;
        int res = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (check(bloomDay, m, k, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    boolean check(int[] arr, int m, int k, int days) {
        int cur = k;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - days <= 0) {
                cur--;
                if (cur == 0) {
                    m--;
                    if (m == 0) {
                        return true;
                    }
                    cur = k;

                }
            } else {
                cur = k;
            }

        }

        return false;
    }
}