package farm.com.inshop;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.enums.BuyTypeButton;

public class ChickenButton extends BuyButton {
    public ChickenButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.chic(0,0,8,8);
        setSize(textureRegion.getRegionWidth()*4, textureRegion.getRegionHeight()*4);
        cost = 50;
        type = BuyTypeButton.CHICKEN;
    }
}
