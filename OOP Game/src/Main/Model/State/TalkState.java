package Main.Model.State;
import Main.Model.Entity.Entity;

/**
 * Created by walkhard on 3/12/16.
 */

public class TalkState extends State{
    //
    public TalkState(Entity player, Entity entity) {
        e = entity;
        p = player;
    }
    //
    Entity e;
    Entity p;

    //
<<<<<<< HEAD
    private void init() {
        option_selected = new Point(0,0);
=======
    private void speak(){System.out.println(p.speak());}
    //
    private void respond(){System.out.println(e.speak());}
    //
    public void talk() {
        speak();
        respond();
>>>>>>> master
    }
}
