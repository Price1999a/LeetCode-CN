package niuke.cn;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class huawei1 {
    /**
     * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
     * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
     * 数据范围：输入的正整数满足
     * 1
     * ≤
     * �
     * ≤
     * 100
     *
     * 1≤n≤100
     * */
    /**
     * 输入例子：
     * 3
     * 10
     * 81
     * 0
     * 输出例子：
     * 1
     * 5
     * 40
     * 例子说明：
     * 样例 1 解释：用三个空瓶换一瓶汽水，剩一个空瓶无法继续交换
     * 样例 2 解释：用九个空瓶换三瓶汽水，剩四个空瓶再用三个空瓶换一瓶汽水，剩两个空瓶，向老板借一个空瓶再用三个空瓶换一瓶汽水喝完得一个空瓶还给老板
     */

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
////            int b = in.nextInt();
//            if (a == 0) break;
//            System.out.println(f1(a));
//        }
//    }

    /**
     * 输入例子：
     * 3
     * 2
     * 2
     * 1
     * 输出例子：
     * 1
     * 2
     * 例子说明：
     * 输入解释：
     * 第一个数字是3，也即这个小样例的N=3，说明用计算机生成了3个1到500之间的随机整数，接下来每行一个随机数字，共3行，也即这3个随机数字为：
     * 2
     * 2
     * 1
     * 所以样例的输出为：
     * 1
     * 2
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int count = in.nextInt();
//        Set<Integer> set = new TreeSet<>();
//        for (int i = 0; i < count; i++) {
//            int a = in.nextInt();
//            set.add(a);
//        }
//        set.forEach(System.out::println);
//        // 注意 hasNext 和 hasNextLine 的区别
////        while (in.hasNextInt()) { // 注意 while 处理多个 case
////            int a = in.nextInt();
////            int b = in.nextInt();
////            System.out.println(a + b);
////        }
//    }

    /*
     * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
     * 输入例子：
        0xAA
        输出例子：
        170
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            System.out.println(f2(a));
        }
    }

    private static int f2(String hex) {
        char[] chars = hex.toCharArray();
        int ret = 0;
        for (int i = 2; i < chars.length; i++) {
            int tmp = 0;
            if (chars[i] <= '9') {
                tmp = chars[i] - '0';
            } else tmp = chars[i] - 'A' + 10;
            ret = (ret << 4) + tmp;
        }
        return ret;
    }

    private static int f1(int x) {
        int res = 0;
        int empty_res = 0;
        while (x > 2) {
            int tmp_1 = x / 3;
            empty_res = x % 3;
            res += tmp_1;
            x = tmp_1 + empty_res;
        }
        if (x == 2) res++;
        return res;
    }
}
