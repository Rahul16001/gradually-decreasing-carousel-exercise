package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.que;
import static com.epam.rd.autotasks.DecrementingCarousel.isRunning;

public class CarouselRun{
    int capacity;
    boolean gradualIncrease;
    int counter = 1;

    CarouselRun(int capacity)
    {
        this.capacity = capacity;
        gradualIncrease = false;
    }
    CarouselRun(int capacity,boolean gradualIncrease)
    {
        this.capacity = capacity;
        this.gradualIncrease = true;
    }

    public int next() {
        int currentElement = -1 ;
        if(que.isEmpty())
        {
            return currentElement;
        }
        else {
            currentElement = que.poll();
            System.out.println("Current element: "+currentElement+" "+gradualIncrease);
            if(!(currentElement-counter <= 0) && !gradualIncrease) que.offer(currentElement-counter);
            if(!(currentElement-counter <= 0) && gradualIncrease)
            {
                que.offer(currentElement-counter);
                counter++;
            }
            if(que.isEmpty())
            {
                isRunning = false;
                gradualIncrease = false;
            }
        }
        return  currentElement;
    }

    public boolean isFinished() {
        return que.isEmpty();
    }
}
