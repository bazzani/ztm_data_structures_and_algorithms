package bevans.ztm.queue;

import bevans.ztm.stack.Stack;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.StringJoiner;

public class QueueWithStacks {

    private Stack s1;
    private Stack s2;
    private Object head;

    public QueueWithStacks() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public Object peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            return head;
        }
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void enqueue(String value) {
        if (s1.isEmpty()) {
            head = value;
        }

        s1.push(value);
    }

    public Object dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.isEmpty() ? null : s2.pop();
    }

    public String printQueue() {
        var joiner = new StringJoiner(",", "[", "]");

        // todo fix printing of rest elements in queue

        return joiner.toString();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
