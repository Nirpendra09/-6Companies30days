class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long start = 1, end = Integer.MAX_VALUE;
        long ans = end;

        while(start <= end) {
            long mid = start + (end - start) / 2;
            if(withinRange(divisor1, divisor2, uniqueCnt1, uniqueCnt2, mid)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int)ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean withinRange(int d1, int d2, int c1, int c2, long mid) {
        int notDivisibleByd1 = (int) (mid - mid / d1);
        int notDivisibleByd2 = (int) (mid - mid / d2);
        long lcm = ((long) d1 * (long) d2) / gcd(d1, d2);

        int notDivisibleByBoth = (int)(mid - mid / lcm);

        if(notDivisibleByd1 >= c1 && notDivisibleByd2 >= c2 && notDivisibleByBoth >= c1 + c2) {
            return true;
        }

        return false;
    }
}