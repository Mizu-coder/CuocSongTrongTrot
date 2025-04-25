package farm.com.buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.MyActor;
import farm.com.Utils;

public class Continue extends MyActor {
    public Continue(float x, float y, Stage s) {
        super(x, y, s);

        textureRegion = new TextureRegion(new Texture("continue.png"));
        setSize(textureRegion.getRegionWidth()*0.7f, textureRegion.getRegionHeight()*0.7f);
    }
}
