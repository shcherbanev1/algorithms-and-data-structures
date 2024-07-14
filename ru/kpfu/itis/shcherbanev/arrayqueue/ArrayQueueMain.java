package ru.kpfu.itis.shcherbanev.homework1;

public class ArrayQueueMain {

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        queue.push(10);
        queue.push(90);
        queue.push(30);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.size);
        System.out.println(queue.top);
        System.out.println(queue.end);
        queue.push(20);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.size);
        System.out.println(queue.top);
        System.out.println(queue.end);
        System.out.println(queue);

    }

}
