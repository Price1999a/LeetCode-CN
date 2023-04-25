package leetcode.cn;

import java.util.SortedMap;
import java.util.TreeMap;

public class Q2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        SortedMap<Integer, String> map = new TreeMap<>((i1, i2) -> {
            return i1 < i2 ? 1 : -1;
        });
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(new String[0]);
    }

}
