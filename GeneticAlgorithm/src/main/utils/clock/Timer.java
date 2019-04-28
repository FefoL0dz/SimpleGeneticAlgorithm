package main.utils.clock;

public class Timer {
    //TODO: create methods to change milliseconds to seconds, minutes and hours.
    private final long initialTime;

    private int seconds;

    private int minutes;

    private int hours;

    private long totalTime;

    public Timer() {
        this.initialTime = System.currentTimeMillis();
    }

    public static Timer initializeCounter() {
        return new Timer();
    }

    public long getInitialTime() {
        return initialTime;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public String getString() {
        refreshTime();
        return("Total Time :" + this.totalTime + " milliSeconds\n"
                + "[Hours: " + this.hours + "] [Minutes: " + this.minutes + "] [Seconds: " + this.seconds + "]");
    }
    public void refreshTime() {
        totalTime = System.currentTimeMillis() - initialTime;
        long totalSeconds = totalTime / 1000;

        long totalMinutes = totalSeconds / 60;
        this.seconds = (int) totalSeconds % 60;

        this.hours = (int) totalMinutes / 60;
        this.minutes = (int) totalMinutes % 60;
    }


    public void printTotalTime() {
        System.out.println(getString());
    }

}
