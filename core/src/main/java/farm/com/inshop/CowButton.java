package farm.com.inshop;

import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.enums.BuyTypeButton;

public class CowButton extends BuyButton {
    public CowButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.cow(0,0,16,16);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        cost = 1000;
        type = BuyTypeButton.COW;
    }
}
