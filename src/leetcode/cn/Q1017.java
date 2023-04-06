package leetcode.cn;

public class Q1017 {
    public static void main(String[] args) {
        System.out.println((-1) % (-2));
        System.out.println((1) % (-2));
        System.out.println(new Q1017().baseNeg2(1));
        System.out.println(new Q1017().baseNeg2(16));
        System.out.println(new Q1017().baseNeg2(4));
    }

    public String baseNeg2(int n) {
        //
        // 5 4 + 1
        //
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder(20);
        while (n != 1) {
            if (n > 0) {
                sb.append(n % -2);
                n /= -2;
            } else {
                int tmp = n % -2;
                n /= -2;
                if (tmp == -1) {
//                    n/=
                    n++;
                    sb.append(1);
                } else sb.append(tmp);
            }
        }
        sb.append(1);

        return sb.reverse().toString();
    }

}
