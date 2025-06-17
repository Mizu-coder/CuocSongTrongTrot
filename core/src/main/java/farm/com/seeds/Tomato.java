package farm.com.seeds;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.enums.ChooseType;
import farm.com.screens.Master;

public class Tomato extends MyActor {
    public Tomato(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.seedpacket(16*3,16,16,16);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        Master.sohat = 4;
    }
}
