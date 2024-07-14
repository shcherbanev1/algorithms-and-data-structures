package ru.kpfu.itis.shcherbanev.homework2;

import java.util.Deque;
import java.util.LinkedList;

public class MyStackQueue<T> {

    private final Deque<T> toPush;
    private final Deque<T> toPop;

    public MyStackQueue() {
        toPush = new LinkedList<>();
        toPop = new LinkedList<>();
    }

    public void push(T value) {
        toPush.push(value);
    }

    public T pop() {
        invert();
        return toPop.pop();
    }

    public T peek() {
        invert();
        return toPop.peek();
    }

    public void invert() {
        if (toPop.isEmpty()) {
            while (!(toPush.isEmpty())) {
                toPop.push(toPush.pop());
            }
        }
    }

}
