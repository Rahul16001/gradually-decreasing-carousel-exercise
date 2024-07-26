package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.carousalQue;
import static com.epam.rd.autotasks.DecrementingCarousel.isRunning;

public class CarouselRun{
    int capacity;
    boolean gradualIncrease;

    CarouselRun(int capacity)
    {
        this.capacity = capacity;
        gradualIncrease = false;
    }
    CarouselRun(int capacity,boolean gradualIncrease)
    {
        this.capacity = capacity;
        this.gradualIncrease = gradualIncrease;}

    public int next() {
        if(carousalQue.isEmpty())
        {
            return -1;
        }
        Pair pairObj = carousalQue.poll();
        if(!gradualIncrease && (pairObj.val - pairObj.decVal) > 0)
        {
            carousalQue.offer(new Pair(pairObj.val-pairObj.decVal, pairObj.decVal));
            return pairObj.val;
        }
        else if(gradualIncrease && (pairObj.val - pairObj.decVal) > 0)
        {
            carousalQue.offer(new Pair(pairObj.val - pairObj.decVal, pairObj.decVal+1));
            return pairObj.val;
        }
        if(carousalQue.isEmpty())
        {
            isRunning = false;
            gradualIncrease = false;
        }
        return pairObj.val;
    }

    public boolean isFinished() {
        return carousalQue.isEmpty();
    }
}
