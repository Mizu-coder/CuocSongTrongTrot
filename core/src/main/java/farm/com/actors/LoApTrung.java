package farm.com.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.MyActor;

public class LoApTrung extends MyActor {
    public LoApTrung(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("lo ap trung.png"));
        setSize(128, 64);
    }

    @Override
    public String toString() {
        return "Lò ấp trứng, nơi ấp ra gà con";
    }
}
