package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Well extends MyActor{
    Well(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*8,16*7, 16,16*2);
        setSize(textureRegion.getRegionWidth()*3, textureRegion.getRegionHeight()*4);
    }
}
