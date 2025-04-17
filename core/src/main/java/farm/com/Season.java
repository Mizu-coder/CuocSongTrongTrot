package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Season extends MyActor{
    TextureRegion he;
    public Season(float x, float y, Stage s) {
        super(x, y, s);
        he = Utils.spri(0,0,16,16);
        setSize(32,32);
    }
}
