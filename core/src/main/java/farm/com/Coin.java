package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Coin extends MyActor{
    public Coin(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("Coin.png"));
        setSize(textureRegion.getRegionWidth()/4, textureRegion.getRegionHeight()/4);

    }
}
