package farm.com.inshop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.enums.SellTypeButton;
import farm.com.screens.Master;

public class PorkButton extends SellButton {
    Master game;
    public PorkButton(float x, float y, Stage s, Master game) {
        super(x, y, s,game);
        this.game = game;
        textureRegion = new TextureRegion(new Texture("meat.png"));
        setSize(64, 32);
        cost = 50;
        type = SellTypeButton.PORK;
    }
}
