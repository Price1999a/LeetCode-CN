package leetcode.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1019 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> pos = new Stack<>();
        //  stack pos 同步操作
        int currentPos = 0;
        while (head != null) {
            int val = head.val;
            head = head.next;
            ans.add(0);
            if (stack.empty()) {
                stack.push(val);
                pos.push(currentPos);
                currentPos++;
            } else {
                while (!stack.empty() && stack.peek() < val) {
                    stack.pop();
                    ans.set(pos.pop(), val);
                }
                stack.push(val);
                pos.push(currentPos);
                currentPos++;
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
