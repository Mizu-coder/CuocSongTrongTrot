package farm.com.inhome;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Pic extends MyActor {
    public Pic(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("pic.png"));
        setSize(100, 100);
    }
}
