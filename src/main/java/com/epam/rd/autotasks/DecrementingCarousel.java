package com.epam.rd.autotasks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecrementingCarousel{

    static boolean isRunning;
    static ArrayDeque<Integer> que;
    final int capacity;
    boolean gradualIncrease;
    public DecrementingCarousel(int cap) {
        isRunning = false;
        que = new ArrayDeque<>();
        capacity = cap;
        gradualIncrease = false;
    }
    public DecrementingCarousel(int cap,boolean gradualIncrease) {
        isRunning = false;
        que = new ArrayDeque<>();
        capacity = cap;
        this.gradualIncrease = true;
    }


    public boolean addElement(int element){
        if(isRunning || que.size() == capacity || element <= 0) return false;
        if(que.offer(element)) return true;
        return false;
    }

    public CarouselRun run() {
        if(!isRunning && !gradualIncrease)
        {
            isRunning = true;
            return new CarouselRun(capacity);
        }
        else if(!isRunning && gradualIncrease)
        {
            isRunning = true;
            return new CarouselRun(capacity,gradualIncrease);
        }

        else return null;
    }

}
