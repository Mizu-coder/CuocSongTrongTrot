package farm.com.water;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.Utils;

public class Water2 extends MyActor {
    public Water2(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.wat(32*3,32*16,32,32);
        setSize(textureRegion.getRegionWidth()*1.25f, textureRegion.getRegionHeight()*7.5f);
    }
}
