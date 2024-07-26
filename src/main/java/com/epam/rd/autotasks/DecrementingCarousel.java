package com.epam.rd.autotasks;

import java.util.ArrayDeque;

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
    static ArrayDeque<Pair> carousalQue;
    final int capacity;
    boolean gradualIncrease;
    public DecrementingCarousel(int cap) {
        isRunning = false;
        carousalQue = new ArrayDeque<>();
        capacity = cap;
        gradualIncrease = false;
    }
    public DecrementingCarousel(int cap,boolean gradualIncrease) {
        isRunning = false;
        carousalQue = new ArrayDeque<>();
        capacity = cap;
        this.gradualIncrease = gradualIncrease;
    }


    public boolean addElement(int element){
        if(isRunning || carousalQue.size() == capacity || element <= 0) return false;
        return carousalQue.offer(new Pair(element, 1));
    }

    public CarouselRun run() {
        if(!isRunning && !gradualIncrease)
        {
            isRunning = true;
            return new CarouselRun(capacity);
        }
        else if(!isRunning)
        {
            isRunning = true;
            return new CarouselRun(capacity,true);
        }
        else return null;
    }

}
