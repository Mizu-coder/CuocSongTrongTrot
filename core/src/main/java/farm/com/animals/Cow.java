package farm.com.animals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.EnergyBar;
import farm.com.Master;
import farm.com.MyActor;
import farm.com.Utils;

public class Cow extends AnimalActor {
    int time;
    Animation<TextureRegion> animation;
    Master game;
    public Cow(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        TextureRegion[] frames = new TextureRegion[3];
        frames[0] = Utils.cow(0,0,16,16);
        frames[1] = Utils.cow(16,0,16,16);
        frames[2] = Utils.cow(16,16,16,16);
        animation = new Animation(0.5f, frames);
        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);

        energyBar = new EnergyBar(getX(), getY() + getHeight() + 4, s);
        minusEnerGy = 1f/40;
        if(energy < 100){
            addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                    if (energy < 100) {
                        if (game.type == 1) {
                            game.seedpu -= 1;
                            energy += 50;
                        }
                        if (game.type == 2) {
                            game.seedc -= 1;
                            energy += 20;
                        }
                        if (game.type == 3) {
                            game.seedp -= 1;
                            energy += 10;
                        }
                        if (game.type == 4) {
                            game.seedt -= 1;
                            energy += 10;
                        }
                        if (game.type == 5) {
                            game.seedb -= 1;
                            energy += 10;
                        }
                    }
                }
            });
        }
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
