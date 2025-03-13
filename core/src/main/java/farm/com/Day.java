package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Day extends MyActor{
    Day(float x, float y, Stage s) {
        super(x, y, s);
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        setColor(0,0,0,1);
        addAction(Actions.sequence(
            Actions.fadeOut(2),
            Actions.removeActor()
        ));
    }
}
