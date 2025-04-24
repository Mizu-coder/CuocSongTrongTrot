package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Tutorial extends MyActor{
    public Tutorial(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("hd.png"));
        setSize(textureRegion.getRegionWidth()/1.75f, textureRegion.getRegionHeight()/1.5f);

    }
}
