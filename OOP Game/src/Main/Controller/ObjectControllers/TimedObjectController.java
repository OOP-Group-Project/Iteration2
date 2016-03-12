package Main.Controller.ObjectControllers;


import Main.Controller.Timer;

/**
 * Created by mason on 3/12/16.
 */
public abstract class TimedObjectController extends ObjectController {
    protected Timer timer;

    public TimedObjectController() {
        this.timer = new Timer();
    }

    public TimedObjectController(int msDuration) {
        this.timer = new Timer(msDuration);
    }

    public void tick() {
        timer.tick();
    }
}
