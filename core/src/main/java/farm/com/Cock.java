package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Cock extends MyActor{
    Cock(float x, float y, Stage s, int size) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("cock.png"));
        setSize(textureRegion.getRegionWidth()*size, textureRegion.getRegionHeight()*size);
    }
}
