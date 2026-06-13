package farm.com.water;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.Utils;

public class WaterDoc extends MyActor {
    public WaterDoc(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.wat(32*5,32*15,32*3,32*3);
        setSize(textureRegion.getRegionWidth()/1.5f, textureRegion.getRegionHeight()/1.5f);
    }
}
