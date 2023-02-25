package leetcode.cn;

public class Q1247 {
    public static void main(String[] a) {
        System.out.println(new SolutionFor1247().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
}

class SolutionFor1247 {
    public int minimumSwap(String s1, String s2) {
        int length = s1.length();
        int xy = 0, yx = 0;
        for (int i = 0; i < length; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (ch1 == 'x' && ch2 == 'y') xy++;
            else if (ch1 == 'y' && ch2 == 'x') yx++;
        }
        if ((xy + yx) % 2 != 0)
            return -1;
        else
            return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }
}