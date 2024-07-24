package com.epam.rd.autotasks;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.epam.rd.autotasks.DecrementingCarousel.que;
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
        this.gradualIncrease = gradualIncrease;
//        System.out.println("I am in");
    }

    public int next() {
        if(que.isEmpty())
        {
            return -1;
        }
        Pair p = que.poll();
        if(!gradualIncrease && (p.val - p.decVal) > 0)
        {
            que.offer(new Pair(p.val-p.decVal, p.decVal));
            return p.val;
        }
        else if(gradualIncrease && (p.val - p.decVal) > 0)
        {
            que.offer(new Pair(p.val - p.decVal, p.decVal+1));
            return p.val;
        }
        if(que.isEmpty())
        {
            isRunning = false;
            gradualIncrease = false;
        }
        return p.val;
    }

    public boolean isFinished() {
        return que.isEmpty();
    }
}
