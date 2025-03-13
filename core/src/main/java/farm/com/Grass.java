package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Grass extends MyActor {

    Grass(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(0,0,16,16);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
    }
}
