package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Pig extends MyActor{
    int time;
    Animation<TextureRegion> animation;
    Pig(float x, float y, Stage s) {
        super(x, y, s);
        TextureRegion[] frames = new TextureRegion[2];
        frames[0] = Utils.pig(0,0,16,16);
        frames[1] = Utils.pig(16,0,16,16);
        animation = new Animation(0.5f, frames);
        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        time += Gdx.graphics.getDeltaTime();
        textureRegion = animation.getKeyFrame(time);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}




