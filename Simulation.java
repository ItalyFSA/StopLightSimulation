import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Simulation
{
    public static int curTimeToRun;
    public static String curState;
    public static String nextState;

    public static void greenState()
    {
        curTimeToRun = 120;
        curState = "green";
        nextState = "yellow";
        System.out.println("Current State: Green");
    }

    public static void yellowState()
    {
        curTimeToRun = 10;
        curState = "yellow";
        nextState = "red";
        System.out.println("Current State: Yellow");
    }

    public static void redState()
    {
        curTimeToRun = 30;
        curState = "red";
        nextState = "green";
        System.out.println("Current State: Red");
    }

    public static void faultState()
    {
        curTimeToRun = 3;
        curState = "fault";
        nextState = "red";
        System.out.println("Current State: Fault");
    }

    public static void main(String[] args)
    {
        greenState();

        long start = System.nanoTime();
        long end, elapsedTime;
        
        while (true)
        {
            end = System.nanoTime();
            elapsedTime = end - start;

            double secondsElapsed = (double)elapsedTime / 1000000000.0;

            switch (curState)
            {
                case "green":
                    if (secondsElapsed > curTimeToRun)
                    {
                        yellowState();
                        start = System.nanoTime();
                    }
                    break;
                case "yellow":
                    if (secondsElapsed >  curTimeToRun)
                    {
                        redState();
                        start = System.nanoTime();
                    } 
                    break;
                case "red":
                    if (secondsElapsed >  curTimeToRun)
                    {
                        greenState();
                        start = System.nanoTime();
                    } 
                    break;
                default:
                    if (secondsElapsed >  curTimeToRun)
                    {
                        faultState();
                        start = System.nanoTime();
                    }
                    break;
            }
        }
    }

}

