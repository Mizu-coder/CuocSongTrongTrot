package farm.com;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.animals.Chicken;
import farm.com.animals.Pig;

public class Home extends MyActor{
    Master game;

    Home(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = Utils.getRegion(0,16*4,16*4,16*4);
        setSize(textureRegion.getRegionWidth()*3, textureRegion.getRegionHeight()*3);
    }

}
