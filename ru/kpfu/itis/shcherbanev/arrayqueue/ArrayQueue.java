package ru.kpfu.itis.shcherbanev.homework1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<T> {

    private final T [] array;
    private final int capacity;
    int size;
    int top;
    int end;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        size = 0;
        top = 0;
        end = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T value) {
        if (size == capacity) {
            throw new ArrayStoreException();
        }
        array[end] = value;
        end++;
        end = end % capacity;
        size++;
    }

    public T pop() {
        T ans = peek();
        top++;
        top %= capacity;
        size--;
        return ans;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[top];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
