package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.que;
import static com.epam.rd.autotasks.DecrementingCarousel.isRunning;

public class CarouselRun{
    int capacity;
    boolean gradualIncrease;
    int counter = 0;
    int mainCounter = 1;


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
//            System.out.println("Current element: "+currentElement+" "+gradualIncrease);
            if(!gradualIncrease) {
                 if(currentElement-1 > 0) que.offer(currentElement - 1);
            }
            if(gradualIncrease)
            {
                if (currentElement-mainCounter > 0) que.offer(currentElement-mainCounter);
//                System.out.println("Current element: "+(currentElement-mainCounter)+" "+mainCounter);
                counter++;
                if(counter % capacity == 0) mainCounter++;
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
