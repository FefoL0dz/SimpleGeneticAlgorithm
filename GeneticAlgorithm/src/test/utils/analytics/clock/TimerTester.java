package test.utils.analytics.clock;

import main.utils.clock.Timer;

public class TimerTester {
    public static void main(String[] args) {
        Timer clock = Timer.initializeCounter();
        delay(69000);
        clock.refreshTime();
        clock.printTotalTime();
    }

    private static void delay(int milliSeconds) {
        try{
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
