package leetcode.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QM17_05 {
    public static void main(String[] a) {
        System.out.println(Arrays.toString(new SolutionForM17_05().findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
    }
}

class SolutionForM17_05 {
    public String[] findLongestSubarray(String[] array) {
        int length = array.length;
//        int[] prefix = new int[length + 1];
        int tmp = 0; // 当前字母数字平衡状态
        int tmpLen = 0;// 当前的子数组长度
        int leftPos = 0, rightPos = 0;
        Map<Integer, Integer> posCache = new HashMap<>();
        posCache.put(0, 0);
        // return 左端点下标值最小
        for (int i = 0; i < length; i++) {
//            posCache.put(tmp, i);
            if (Character.isDigit(array[i].charAt(0))) {
                tmp++;
            } else {
                tmp--;
            }
            // 现在就是prrfix[i+1] 对应的tmp
            int left = posCache.getOrDefault(tmp, i + 1);
            if (i + 1 - left > tmpLen) {
                leftPos = left;
                rightPos = i + 1;
                tmpLen = i + 1 - left;
            }
            posCache.putIfAbsent(tmp, i + 1);
        }
//        System.out.println(leftPos + " " + rightPos);
        return tmpLen == 0 ? new String[]{} : Arrays.copyOfRange(array, leftPos, rightPos);
//        return null;
    }
}