package farm.com.inshop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.enums.SellTypeButton;
import farm.com.screens.Master;

public class EggButton extends SellButton {
    Master game;
    public EggButton(float x, float y, Stage s,Master game ) {
        super(x, y, s,game);
        this.game = game;
        textureRegion = new TextureRegion(new Texture("egg.png"));
        setSize(64, 64);
        cost = 5;
        type = SellTypeButton.EGG;
    }
}
