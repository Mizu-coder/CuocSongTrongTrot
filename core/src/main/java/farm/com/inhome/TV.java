package farm.com.inhome;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class TV extends MyActor {
    public TV(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("tv.png"));
        setSize(textureRegion.getRegionWidth()/3.75f,textureRegion.getRegionHeight()/3.75f);
    }
}
