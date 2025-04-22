package farm.com.animals;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.*;
import farm.com.enums.AnimalNames;
import farm.com.screens.Master;

import java.util.Random;

public class Cow extends AnimalActor {
    float time;
    Animation<TextureRegion> animation;
    Master game;
    BucketMilk bucketMilk;
    public Cow(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        name = AnimalNames.COW;
        TextureRegion[] frames = new TextureRegion[2];
        frames[0] = Utils.cow(0,0,16,16);
         frames[1] = Utils.cow(16,0,16,16);
       // frames[2] = Utils.cow(32,0,16,16);
        animation = new Animation<>(0.2f, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        textureRegion = animation.getKeyFrame(time);
        time = 0;

        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);

        energyBar = new EnergyBar(getX(), getY() + getHeight() + 4, s);
        minusEnerGy = 1f/40;


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
                    if(energy >= 50){
                        if(age > 5){
                            bucketMilk.remove();
                            GameState.milkTotal += milk;
                            new ShowInfo(getX()+ getWidth() +4,  getY()+ getHeight() + 4, s, "+" + (int) milk + " bucket milk", 8).fadeOut();
                            energy -= 20;
                            age = 1;
                        }
                    }

                }
            });

            bucketMilk = new BucketMilk(getX()+ getWidth() +4,  getY()+ getHeight() + 4, s, game);
            bucketMilk.remove();
        energy = 500;
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        textureRegion = animation.getKeyFrame(time);

        if(age > 3){
            textureRegion = Utils.cow(32,0,16,16);
            if(bucketMilk.getStage() == null){
                getStage().addActor(bucketMilk);
            }
        }
    }
}
