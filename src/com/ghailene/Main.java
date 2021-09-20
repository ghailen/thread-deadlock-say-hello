package com.ghailene;

public class Main {
public static Object lock1 = new Object();
public static Object lock2 = new Object();
    public static void main(String[] args) {
	// write your code here
        new Thread1().start();
        new Thread2().start();
    }


    private static class Thread1 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("thread 1 : has lock1");
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 : waiting for lock 2");
                synchronized (lock2){
                    System.out.println("Thread 1 : has lock1 and lock2");
                }
                System.out.println("Thread 1 : Released lock 2");
            }
            System.out.println("Thread 1 :Released lock1. exiting");
        }
}

    private static class Thread2 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("thread 2 : has lock1");
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2 : waiting for lock 2");
                synchronized (lock2){
                    System.out.println("Thread 2 : has lock1 and lock2");
                }
                System.out.println("Thread 2 : Released lock 2");
            }
            System.out.println("Thread 2 :Released lock1. exiting");
        }
    }




}
