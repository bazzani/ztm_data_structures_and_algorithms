package bevans.ztm.stack;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueues {

    private Queue<String> q1;
    private Queue<String> q2;
    private String top;

    public StackWithQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(String value) {
        q1.offer(value);
        top = value;
    }

    public String pop() {
        String popped = null;

        while (!q1.isEmpty()) {
            popped = q1.poll();

            if (!q1.isEmpty()) {
                q2.offer(popped);
            } else {
                top = null;
            }
        }

        while (!q2.isEmpty()) {
            top = q2.poll();
            q1.offer(top);
        }

        return popped;
    }

    public String peek() {
        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
