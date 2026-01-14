package farm.com.inhome;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Heater extends MyActor {
    public Heater(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("heater.png"));
        setSize(textureRegion.getRegionWidth()/3.5f,textureRegion.getRegionHeight()/3.5f);
    }
}
