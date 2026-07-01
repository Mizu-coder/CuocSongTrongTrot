package farm.com.inshop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.enums.BuyTypeButton;

public class SePButton extends BuyButton{
    public SePButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("packpa.png"));
        setSize(25,27);
        cost = 100;
        type = BuyTypeButton.SEP;
    }
}
