package farm.com.inhome;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class WallDR extends MyActor {
    public WallDR(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("walldr.png"));
        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight()/1.25f);
    }
}
