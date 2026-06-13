package farm.com.water;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.Utils;

public class WaterR extends MyActor {
    public WaterR(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.wat(32*21,32*9,112,80);
        setSize(textureRegion.getRegionWidth()/1.5f, textureRegion.getRegionHeight()/1.5f);
    }
}
