package farm.com.intv;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Edu extends MyActor {
    public Edu(float x, float y, Stage s){
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("edu.png"));
        setSize(textureRegion.getRegionWidth()/1.25f, textureRegion.getRegionHeight()/1.25f);
    }
}
