package farm.com.inhome;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class Bed extends MyActor {
    public Bed(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("bed.jpg"));
        setSize(textureRegion.getRegionWidth()/2,textureRegion.getRegionHeight()/2);
    }
}
