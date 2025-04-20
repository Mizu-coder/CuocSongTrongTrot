package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Shop extends MyActor{
    Master game;
    Shop(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        textureRegion = new TextureRegion(new Texture("Shop.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);

    }
}
