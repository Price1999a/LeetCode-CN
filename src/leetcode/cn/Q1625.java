package leetcode.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Q1625 {

    public static void main(String[] a) {
        System.out.println(new SolutionFor1625().findLexSmallestString("43987654", 7, 3));
    }
}

class SolutionFor1625 {
    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> resSet = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        resSet.add(s);
//        queue.add(s);
        queue.offer(s);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            String s_a = f_a(str, a);
            String s_b = f_b(str, b);
            if (resSet.add(s_a)) {
                queue.offer(s_a);
            }
            if (resSet.add(s_b)) {
                queue.offer(s_b);
            }
        }
        return resSet.first();
    }

    private String f_a(String s, int a) {
        /*累加：将 a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。
        数字一旦超过 9 就会变成 0，如此循环往复。
        例如，s = "3456" 且 a = 5，则执行此操作后 s 变成 "3951"。*/
        StringBuilder stringBuilder = new StringBuilder(s.length());
        boolean flag = false;
        for (char ch : s.toCharArray()) {
            if (flag) {
                ch = (char) ((ch - '0' + a) % 10 + '0');
            }
            stringBuilder.append(ch);
            flag = !flag;
        }
        return stringBuilder.toString();
    }

    private String f_b(String s, int b) {
        /* 轮转：将 s 向右轮转 b 位。例如，s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。*/
        b %= s.length();
        return s.substring(s.length() - b) +
                s.substring(0, s.length() - b);
    }

    public void unitTest() {
        System.out.println(f_a("11223344556677889900", 1));
        System.out.println(f_b("0123456789", 3));
    }

    public static void main(String[] a) {
        new SolutionFor1625().unitTest();
    }

}