package bevans.ztm.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCodeQueueSolution2 {
    private Integer front;
    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;

    public LeetCodeQueueSolution2() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }

    public void push(int value) {
        if (stack1.isEmpty()) {
            front = value;
        }

        stack1.push(value);
    }

    public Integer pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) { // needed to avoid java.util.NoSuchElementException
            return null;
        } else {
            return stack2.pop();
        }
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public Integer peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
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
