package leetcode.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public class Q1792 {

    public static void main(String[] a) {
        int[][] classes = new int[][]{{1, 2}, {3, 5}, {2, 2}};
        int extra = 2;
        System.out.println(new SolutionFor1792().maxAverageRatio(classes, extra));
    }
}


class SolutionFor1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double ret = 0;
        Queue<double[]> pq = new PriorityQueue<>((i1, i2) -> {
            double passDelta1 = (i1[0] + 1) / (i1[1] + 1) - (i1[0]) / (i1[1]);
            double passDelta2 = (i2[0] + 1) / (i2[1] + 1) - (i2[0]) / (i2[1]);
            return -Double.compare(passDelta1, passDelta2);
        });
        Arrays.stream(classes).forEach(i -> {
            pq.add(new double[]{i[0], i[1]});
        });
        for (int i = 1; i <= extraStudents; i++) {
            double[] tmp = pq.poll();
            assert tmp != null;
            tmp[0]++;
            tmp[1]++;
            pq.add(tmp);
        }
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        pq.forEach(d -> total.updateAndGet(v -> (v + d[0] / d[1])));
        ret = total.get() / classes.length;
        return ret;
    }
}