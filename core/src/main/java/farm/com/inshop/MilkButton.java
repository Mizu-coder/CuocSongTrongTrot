package farm.com.inshop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.enums.SellTypeButton;

public class MilkButton extends SellButton {
    public MilkButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("bucket.png"));
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        cost = 70;
        type = SellTypeButton.MILK;
    }
}
