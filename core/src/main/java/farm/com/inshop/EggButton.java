package farm.com.inshop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.enums.SellTypeButton;

public class EggButton extends SellButton {
    public EggButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("Chick_sell.png"));
        setSize(64, 32);
        cost = 5;
        type = SellTypeButton.EGG;
    }
}
