package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Lake extends MyActor{
    Lake(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("lake.png"));
       setSize(textureRegion.getRegionWidth()*10, textureRegion.getRegionHeight()*8);
    }
}
