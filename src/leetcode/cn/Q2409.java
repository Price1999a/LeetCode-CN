package leetcode.cn;

public class Q2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        return Math.max(0,
                1 +
                        Math.min(
                                prefixDays(
                                        Integer.parseInt(leaveAlice.substring(0, 2)),
                                        Integer.parseInt(leaveAlice.substring(3))),
                                prefixDays(
                                        Integer.parseInt(leaveBob.substring(0, 2)),
                                        Integer.parseInt(leaveBob.substring(3))))
                        -
                        Math.max(prefixDays(
                                        Integer.parseInt(arriveAlice.substring(0, 2)),
                                        Integer.parseInt(arriveAlice.substring(3))),
                                prefixDays(
                                        Integer.parseInt(arriveBob.substring(0, 2)),
                                        Integer.parseInt(arriveBob.substring(3))))
        );
    }

    int[] datesOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int prefixDays(int mouth, int day) {
        int ret = 0;
        for (int i = 0; i < mouth; i++) {
            ret += datesOfMonths[i];
        }
        return ret + day;
    }
}
