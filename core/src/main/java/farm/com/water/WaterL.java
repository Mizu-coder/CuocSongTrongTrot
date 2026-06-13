package farm.com.water;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.Utils;

public class WaterL extends MyActor {
    public WaterL(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.wat(32 * 34, 32 * 15, 120, 32 * 3);
        setSize(textureRegion.getRegionWidth()/1.5f, textureRegion.getRegionHeight()/1.5f);
    }
}
