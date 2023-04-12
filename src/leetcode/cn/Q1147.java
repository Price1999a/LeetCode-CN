package leetcode.cn;

public class Q1147 {
    public static void main(String[] args) {
        System.out.println(new Q1147().longestDecomposition("merchant"));
        System.out.println(new Q1147().longestDecomposition("aaa"));
    }

    public int longestDecomposition(String text) {
        char[] chars = text.toCharArray();
        StringBuilder left = new StringBuilder(), right = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        int count = 0;
//        stringBuffer.appen
//        left.reverse()
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            left.append(chars[i]);
//            right.append(chars[j]);
            right.insert(0, chars[j]);
            if (i == j) break;
            if (right.toString().equals(left.toString())) {
                right.delete(0, right.length());
                left.delete(0, left.length());
                count++;
            }
        }
        return left.length() == 0 ? (count * 2) : (count * 2 + 1);
    }

}
