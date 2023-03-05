package leetcode.cn;

public class Q1599 {
}

class SolutionFor1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ret = -1;
        int maxBonus = 0, iter = 0, tmpBonus = 0, wait = 0;
        while (wait > 0 || iter < customers.length) {
            wait += iter < customers.length ? customers[iter] : 0;
            int upNum = Math.min(4, wait);
            wait -= upNum;
            iter++;
            tmpBonus += upNum * boardingCost - runningCost;
            if (tmpBonus > maxBonus) {
                maxBonus = tmpBonus;
                ret = iter;
            }
        }

        return ret;
    }
}