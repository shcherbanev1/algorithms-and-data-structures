package ru.kpfu.itis.shcherbanev.homework2;

public class StackQueueMain {

    public static void main(String[] args) {
        MyStackQueue<Integer> myStackQueue = new MyStackQueue<>();
        myStackQueue.push(10);
        myStackQueue.push(20);
        myStackQueue.push(30);
        System.out.println(myStackQueue.pop());
        System.out.println(myStackQueue.peek());
    }

}
