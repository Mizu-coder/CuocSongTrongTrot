package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Home extends MyActor{
    Home(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(0,16*4,16*4,16*4);
        setSize(textureRegion.getRegionWidth()*3, textureRegion.getRegionHeight()*3);
    }
}
