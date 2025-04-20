package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Shop extends MyActor{
    public Shop(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("Shop.png"));
        setSize(textureRegion.getRegionWidth()/4, textureRegion.getRegionHeight()/4);

    }
}
