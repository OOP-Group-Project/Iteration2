package Main.Controller;

/**
 * Created by mason on 3/12/16.
 */
public class Timer {
    private long startTime;
    private int duration;
    private boolean expired;

    public Timer() {
        this.duration = 100000;
    }

    public Timer(int msDuration) {
        this.duration = msDuration;
    }

    public void start() {
        startTime = System.currentTimeMillis();
        expired = false;
    }

    public void start(int msDuration) {
        startTime = System.currentTimeMillis();
        expired = false;
        duration = msDuration;
    }

    public boolean isExpired() {
        return expired;
    }

    public void tick() {
        long currentTime = System.currentTimeMillis();
        if((currentTime - startTime) > duration && !expired) {
            expired = true;
        }
    }
}
