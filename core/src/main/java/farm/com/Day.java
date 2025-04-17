package farm.com;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import farm.com.screens.GameScreen;

public class Day extends MyActor{
    public Day(float x, float y, Stage s) {
        super(x, y, s);
        setSize(GameScreen.WIDTH, GameScreen.HEIGHT);
        setColor(0,0,0,1);
        addAction(Actions.sequence(
            Actions.fadeOut(2),
            Actions.removeActor()
        ));
    }
}
