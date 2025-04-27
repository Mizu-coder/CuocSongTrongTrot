package farm.com.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Guide extends MyActor {
    public Guide(float x, float y, Stage s) {
        super(x, y, s);

        textureRegion = new TextureRegion(new Texture("guide.jpg"));
        setSize(64, 32);
    }
}
