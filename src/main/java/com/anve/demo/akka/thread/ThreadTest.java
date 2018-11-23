package com.anve.demo.akka.thread;

/**
 * Created by ximeng 2018/11/22.
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        });

        thread.start();

        // 在main线程中, join的调用者thread内容都执行完了, 再执行main
        thread.join();

        System.out.println("end");
    }

}
