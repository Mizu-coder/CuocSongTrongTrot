package farm.com.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Start extends MyActor {
    public Start(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("start.jpg"));
        setSize(100,32);
    }
}
