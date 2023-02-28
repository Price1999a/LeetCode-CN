package leetcode.cn;

import java.util.*;

public class Q2363 {
    public static void main(String[] a) {
        int[][] items1 = new int[][]{{1, 1}, {4, 5}, {3, 8}},
                items2 = new int[][]{{3, 1}, {1, 5}};
        System.out.println(new SolutionFor2363().mergeSimilarItems(items1, items2));
    }
}

class SolutionFor2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        SortedMap<Integer, Integer> maps = new TreeMap<>();
        for (int[] i :
                items1) {
            maps.put(i[0], i[1]);
        }
        for (int[] i :
                items2) {
            maps.merge(i[0], i[1], Integer::sum);
        }
        List<List<Integer>> ret = new ArrayList<>(maps.size());
        maps.forEach((k, v) -> {
            ret.add(Arrays.asList(k, v));
        });
        return ret;

    }
}