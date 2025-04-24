package farm.com.inshop;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.enums.BuyTypeButton;

public class PigButton extends BuyButton {
    public PigButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.piglet(0,0,8,8);
        setSize(textureRegion.getRegionWidth()*4, textureRegion.getRegionHeight()*4);
        cost = 200;
        type = BuyTypeButton.PIG;
    }
}
