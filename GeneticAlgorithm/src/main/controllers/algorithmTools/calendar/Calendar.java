package main.controllers.algorithmTools.calendar;

public class Calendar {

    private int currentEpoch;

    private final int endOfTimes;

    public Calendar(final int endOfTimes) {
        this.currentEpoch = 0;
        this.endOfTimes = endOfTimes;
    }

    //setter
    public void updateEpoch() {
        this.currentEpoch ++;
    }

    //getters
    public int getCurrentEpoch() {
        return this.currentEpoch;
    }

    public int getEndOfTimes() {
        return this.endOfTimes;
    }

    //verifiers
    public boolean isNowTheEndOfTimes() {
        if(this.currentEpoch < this.endOfTimes) return false;
        return true;
    }

    public int timeLeft() {
        return this.endOfTimes - this.currentEpoch;
    }


    //exhibitors
    public void showCurrentEpoch() { System.out.println("Current epoch = " + this.currentEpoch); }

    public void showEndOfTimes() { System.out.println("End of Times = " + this.endOfTimes); }

    public void showTimeLeft() { System.out.println("Time left before apocalypse = " + this.timeLeft()); }

    public void showInfos() {
        System.out.println("Calendar information: ");
        showCurrentEpoch();
        showEndOfTimes();
        showTimeLeft();
        System.out.println("------------------------------------------------");
    }
}
