package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class EnergyBar extends MyActor{
    public EnergyBar(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("energy.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
        setColor(0, 1, 0, 1);
    }

}
