package farm.com.soilpaddy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class R4 extends MyActor {
    public R4(float x, float y, Stage s){
        super(x,y,s);
        textureRegion = new TextureRegion(new Texture("ruong4.jpg"));
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}
