package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SoilP extends MyActor{
    public SoilP(float x, float y, Stage s){
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("ruonglua.png"));
        setSize(textureRegion.getRegionWidth()/1.25f, textureRegion.getRegionHeight()/1.25f);
    }
}
