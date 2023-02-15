package leetcode.cn;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Q1250 {

    public static void main(String[] args) {
        int[] input = {3,6};
        System.out.println(new SolutionFor1250().isGoodArray(input));
    }
}

class SolutionFor1250 {
    public boolean isGoodArray(int[] nums) {
        if (nums.length == 0) return false;
        AtomicInteger tmp = new AtomicInteger(nums[0]);
        Arrays.stream(nums).forEachOrdered(i -> tmp.set(gcd(tmp.get(), i)));
        return tmp.get() == 1;
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        if (p == 0) return q;

        // p and q even
        if ((p & 1) == 0 && (q & 1) == 0) return gcd(p >> 1, q >> 1) << 1;

            // p is even, q is odd
        else if ((p & 1) == 0) return gcd(p >> 1, q);

            // p is odd, q is even
        else if ((q & 1) == 0) return gcd(p, q >> 1);

            // p and q odd, p >= q
        else if (p >= q) return gcd((p - q) >> 1, q);

            // p and q odd, p < q
        else return gcd(p, (q - p) >> 1);
    }
}
