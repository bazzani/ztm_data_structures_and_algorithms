package bevans.ztm.linkedlist;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.w3c.dom.Node;

import java.util.StringJoiner;

public class LinkedList {

    public LinkedList() {
    }

    public LinkedList(Object value) {
    }

    public int length() {
        return 0;
    }

    public void append(Object value) {
    }

    public void prepend(Object value) {
    }

    public void insert(int index, Object value) {
    }

    public void remove(int index) {
    }

    private Node traverseToIndex(int index) {
        return null;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
    }

    String printList() {
        var joiner = new StringJoiner(",", "[", "]");
        return joiner.toString();
    }

    public LinkedList reverse() {
        return null;
    }

    public LinkedList reverseZtm() {
        return null;
    }

    public void reverseBarry() {

    }

    public void reverseBarryTwo() {
    }

    private static class Node {
    }
}
