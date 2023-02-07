package leetcode.cn;

import java.util.*;

public class Q1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Set<String> ret = new TreeSet<>();

        Map<String, List<Integer>> record = new HashMap<>();
        // record 中记录了某人工卡使用状况 也就是名字 对应的工卡打卡时间组
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String[] time = keyTime[i].split(":");
            List<Integer> times = record.get(name);
            int newTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if (times == null) {
                times = new ArrayList<>();
                record.put(name, times);
            }
            times.add(newTime);
        }

        // 在全部放进来之后 这里要进行排序 再使用类似于滑动窗口的方法判断这个人的情况
        record.forEach((k, v) -> {
            int size = v.size();
            Collections.sort(v);
            if (size >= 3) {
                for (int i = 0; i + 2 < size; i++) {
                    if (v.get(i + 2) - v.get(i) <= 60) {
                        ret.add(k);
                        break;
                    }
                }
            }
        });
        return ret.stream().sorted().toList();
    }

    public static void main(String[] args) {
        String[] keyName = {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"};
        String[] keyTime = {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};

        Q1604 q = new Q1604();

        System.out.println(Arrays.toString(q.alertNames(keyName, keyTime).toArray()));
    }
}
