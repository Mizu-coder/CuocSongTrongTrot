package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Animals extends MyActor{
    public Animals(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("Animals.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);

    }
}
