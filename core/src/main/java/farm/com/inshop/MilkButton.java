package farm.com.inshop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.enums.SellTypeButton;
import farm.com.screens.Master;

public class MilkButton extends SellButton {
    Master game;
    public MilkButton(float x, float y, Stage s,Master game) {
        super(x, y, s, game);
        this.game = game;
        textureRegion = new TextureRegion(new Texture("bucket.png"));
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        cost = 70;
        type = SellTypeButton.MILK;
    }
}
