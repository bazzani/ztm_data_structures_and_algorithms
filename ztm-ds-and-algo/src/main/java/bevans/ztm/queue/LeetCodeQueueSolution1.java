package bevans.ztm.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class LeetCodeQueueSolution1 {
    private Integer front;
    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;

    public LeetCodeQueueSolution1() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }

    public void push(int value) {
        if (stack1.isEmpty()) {
            front = value;
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack2.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public Integer pop() {
        Integer res = null;
        if (!stack1.isEmpty()) {
            res = stack1.pop();
        }

        if (!stack1.isEmpty())
            front = stack1.peek();

        return res;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public Integer peek() {
        return front;
    }

    public String printQueue() {
        var joiner = new StringJoiner(",", "[", "]");

        for (var s : stack1) {
            joiner.add(s.toString());
        }

        return joiner.toString();
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
