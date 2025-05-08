package farm.com.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.MyActor;
import farm.com.Utils;
import farm.com.animals.Chicken;
import farm.com.screens.GameScreen;
import farm.com.utils.Cell;

public class TrungDeAp extends MyActor {
    public float time;
    public final float TIMEUP = 5;
    public TrungDeAp(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("egg1.png"));
        setSize(64, 64);

        time = 0;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(time < TIMEUP) {
            time += delta;
        } else {
            // no roi
            textureRegion = Utils.chic(8,0,8,8);
            setSize(64, 64);
        }
    }
}
