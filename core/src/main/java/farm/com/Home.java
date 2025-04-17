package farm.com;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.screens.Master;

public class Home extends MyActor{
    Master game;

    public Home(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = Utils.getRegion(0,16*4,16*4,16*4);
        setSize(textureRegion.getRegionWidth()*3, textureRegion.getRegionHeight()*3);
    }

}
