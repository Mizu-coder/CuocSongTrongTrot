package farm.com.water;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.seeds.PumkinSeed;

public class WaterLU extends MyActor {
    public WaterLU(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.wat(956,32*9,105,100);
        setSize(textureRegion.getRegionWidth()*1.05f, textureRegion.getRegionHeight()*1.05f);
    }
}
