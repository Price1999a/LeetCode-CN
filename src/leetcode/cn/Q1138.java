package leetcode.cn;

public class Q1138 {

    /*
     * board = [
     * "abcde",
     * "fghij",
     * "klmno",
     * "pqrst",
     * "uvwxy",
     * "z"
     * ]
     * x 横向 0 1 2 3 4
     * y 纵向 0 1 2 3 4 5
     * */

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int cx = 0, cy = 0;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int chx = (ch - 'a') % 5;   // 行
            int chy = (ch - 'a') / 5;   // 列
            if (cy > chy) {
                sb.append("U".repeat(cy - chy));
                cy = chy;
            }
            if (cx > chx) {
                sb.append("L".repeat(cx - chx));
                cx = chx;
            }
            if (cy < chy) {
                sb.append("D".repeat(chy - cy));
                cy = chy;
            }
            if (cx < chx) {
                sb.append("R".repeat(chx - cx));
                cx = chx;
            }
            sb.append("!");
        }

//        "x".repeat(x)

        return sb.toString();
    }

    public static void main(String[] args) {
        Q1138 q = new Q1138();
        System.out.println(q.alphabetBoardPath("leet"));
    }
}
