package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Soil extends MyActor{
    Soil(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16, 16*2, 16, 16);
        setSize(textureRegion.getRegionWidth()*2 , textureRegion.getRegionHeight()*2);
    }
}
