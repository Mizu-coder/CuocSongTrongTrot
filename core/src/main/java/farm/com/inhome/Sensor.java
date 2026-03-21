package farm.com.inhome;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;
import farm.com.screens.Master;

public class Sensor extends MyActor {
    public Sensor(float x, float y, Stage s){
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("comeback.png"));
        setSize(textureRegion.getRegionWidth()/1.5f,textureRegion.getRegionHeight()/1.5f);
    }
}
