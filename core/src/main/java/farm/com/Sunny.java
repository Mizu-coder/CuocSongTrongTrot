package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Sunny extends MyActor{
    Sunny(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("sunny.jpg"));
        setSize(textureRegion.getRegionWidth()/2f, textureRegion.getRegionHeight()/2f);
    }
}
