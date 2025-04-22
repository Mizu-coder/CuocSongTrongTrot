package farm.com.animals;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class PigCost extends MyActor {
    public PigCost(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("Pig_sell.png"));
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2.23f);
    }
}
