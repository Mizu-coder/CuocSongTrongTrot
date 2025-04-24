package farm.com.inshop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.enums.SellTypeButton;

public class EggButton extends SellButton {
    public EggButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("egg.png"));
        setSize(64, 64);
        cost = 5;
        type = SellTypeButton.EGG;
    }
}
