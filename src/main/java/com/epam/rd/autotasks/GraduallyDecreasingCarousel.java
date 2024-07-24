package com.epam.rd.autotasks;

import java.util.Scanner;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity,true);
    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        DecrementingCarousel carousel = new GraduallyDecreasingCarousel(3);
//        CarouselRun carRun = null;
//        int inp;
//
//        while(true)
//        {
//            System.out.println("Press 1 to add Element");
//            System.out.println("Press 2 to run carousal");
//            System.out.println("Press 3 to do next");
//            System.out.println("Press 4 to check Finished");
//            inp = scan.nextInt();
//            if(inp == 1)
//            {
//                int num = scan.nextInt();
//                System.out.println(carousel.addElement(num));
//            }
//            else if(inp == 2)
//            {
//                if(carRun != null) System.out.println("Already Running");
//                else
//                {
//                    carRun = carousel.run();
//                    System.out.println("Run started");
//                }
//            }
//            else if(inp == 3)
//            {
//                if(carRun != null)
//                {
//                    System.out.println(carRun.next());
//                }
//                else System.out.println("Carousal not running");
//            }
//            else if(inp == 4)
//            {
//                if(carRun != null)
//                {
//                    System.out.println(carRun.isFinished());
//                }
//                else{
//                    System.out.println("Carousal not running");
//                }
//            }
//        }
//    }
}
