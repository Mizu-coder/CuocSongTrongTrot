package farm.com.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.MyActor;
import farm.com.Utils;

public class Save extends MyActor {
    public Save(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("save.png"));
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}
