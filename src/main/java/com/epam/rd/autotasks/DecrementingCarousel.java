package com.epam.rd.autotasks;

import java.util.ArrayDeque;
import java.util.Scanner;

class Pair
{
    int val;
    int decVal;
    Pair(int val,int decVal)
    {
        this.val = val;
        this.decVal = decVal;
    }
}
public class DecrementingCarousel{

    static boolean isRunning;
    static ArrayDeque<Pair> que;
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
        this.gradualIncrease = gradualIncrease;
    }


    public boolean addElement(int element){
        if(isRunning || que.size() == capacity || element <= 0) return false;
        if(que.offer(new Pair(element,1))) return true;
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
            return new CarouselRun(capacity,true);
        }
        else return null;
    }

}
