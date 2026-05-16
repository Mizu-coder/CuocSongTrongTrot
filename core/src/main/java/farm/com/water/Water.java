package farm.com.water;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.Utils;

public class Water extends MyActor {
    public Water(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.wat(32*9,32*15,112,32*3);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}
