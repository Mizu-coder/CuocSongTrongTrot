package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Day extends MyActor{
    Master game;
    Day(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        setColor(0,0,0,1);
        addAction(Actions.sequence(
            Actions.fadeOut(5),
            Actions.run(()-> {
                game.check = 0;
            }),
            Actions.removeActor()
        ));
    }
}
