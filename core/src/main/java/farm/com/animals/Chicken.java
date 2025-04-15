package farm.com.animals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.EnergyBar;
import farm.com.GameScreen;
import farm.com.Master;
import farm.com.Utils;

public class Chicken extends AnimalActor {
    int time;
    Animation<TextureRegion> animation;
    Master game;
    GameScreen gameScreen;
    public int age;
    public Chicken(float x, float y, Stage s, Master game) {
        super(x, y, s);
        TextureRegion[] frames = new TextureRegion[2];
        this.game = game;
        gameScreen = new GameScreen(game);
        frames[0] = Utils.chic(0,0,8,8);
        frames[1] = Utils.chic(16,0,8,8);
        animation = new Animation(0.5f, frames);
        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);

        energyBar = new EnergyBar(getX(), getY() + getHeight() + 4, s);
        minusEnerGy = 1f/60;
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
        if(age >= 3){
            textureRegion = Utils.chike(0,0,8,8);
            textureRegion = Utils.chike(8,0,8,8);
        }
    }
}
