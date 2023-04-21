package leetcode.cn;

public class Q2413 {
    public int smallestEvenMultiple(int n) {
        if (n == 1 || n == 2) return n;
        return n * 2 / gcd(n, 2);
    }

    //  输入要求 x>y
    private int gcd(int x, int y) {
        if (x % y == 0) return y;
        else return gcd(y, x % y);
    }
}
