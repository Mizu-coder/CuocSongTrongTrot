package farm.com.intv;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Tur3 extends MyActor {
    public Tur3(float x, float y, Stage s){
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("tu3.png"));
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}
