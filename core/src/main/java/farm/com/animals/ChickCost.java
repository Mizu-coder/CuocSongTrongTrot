package farm.com.animals;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.MyActor;

public class ChickCost extends MyActor {
    public ChickCost(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("Chick_sell.png"));
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2.225f);
    }
}
