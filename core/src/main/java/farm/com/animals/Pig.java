package farm.com.animals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.EnergyBar;
import farm.com.Utils;

public class Pig extends AnimalActor {
    float time;
    public int age = 1;
    Animation<TextureRegion> animation;
    Animation<TextureRegion> animationBig;

    public Pig(float x, float y, Stage s) {
        super(x, y, s);
        TextureRegion[] frames = new TextureRegion[2];
        frames[0] = Utils.piglet(0,0,8,8);
        frames[1] = Utils.piglet(8,0,8,8);
        animation = new Animation<>(0.2f, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);

        TextureRegion[] frames1 = new TextureRegion[2];
        frames1[0] = Utils.pig(0,0,16,8);
        frames1[1] = Utils.pig(16,0,16,8);
        animationBig = new Animation<>(0.2f, frames1);
        animationBig.setPlayMode(Animation.PlayMode.LOOP);

        energyBar = new EnergyBar(getX(), getY() + getHeight() + 4, s);
        minusEnerGy = 1f/30;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        textureRegion = animation.getKeyFrame(time);
        if(age >= 2){
           // textureRegion = Utils.pig(0,0,16,8);
            textureRegion = animationBig.getKeyFrame(time);
            setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
        }
    }

}




