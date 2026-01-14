package farm.com.inhome;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Chair extends MyActor {
    public Chair(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("chair.png"));
        setSize(textureRegion.getRegionWidth()/3,textureRegion.getRegionHeight()/3);
    }
}
