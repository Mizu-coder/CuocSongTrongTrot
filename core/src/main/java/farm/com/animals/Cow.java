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
import farm.com.enums.ChooseType;
import farm.com.screens.Master;

import java.util.Random;

public class Cow extends AnimalActor {
    float time;
    Animation<TextureRegion> animation;
    BucketMilk bucketMilk;
    public Cow(float x, float y, Stage s) {
        super(x, y, s);
        name = AnimalNames.COW;
        TextureRegion[] frames = new TextureRegion[2];
        frames[0] = Utils.cow(0,0,16,16);
         frames[1] = Utils.cow(16,0,16,16);
       // frames[2] = Utils.cow(32,0,16,16);
        animation = new Animation<>(0.2f, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        textureRegion = animation.getKeyFrame(time);
        time = 0;

        setSize(textureRegion.getRegionWidth()*4,textureRegion.getRegionHeight()*4);

        energyBar = new EnergyBar(getX(), getY() + getHeight() + 4, s);
        minusEnerGy = 1f/40;


            addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                    if(ill && Master.type.equals(ChooseType.KIMTIEM) && GameState.soKimTiem > 0){
                        ill = false;
                        GameState.soKimTiem--;
                    }
                    if (energy < 100) {
                        switch (Master.type){
                            case PUMKIN -> {
                                GameState.seedpu -= 1;
                                energy += 50;
                            }
                            case CAROT -> {
                                GameState.seedc -= 1;
                                energy += 20;
                            }
                            case POTATO -> {
                                GameState.seedp -= 1;
                                energy += 10;
                            }
                            case TOMATO -> {
                                GameState.seedt -= 1;
                                energy += 10;
                            }
                            case BEAN -> {
                                GameState.seedb -= 1;
                                energy += 10;
                            }
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

            bucketMilk = new BucketMilk(getX()+ getWidth() +4,  getY()+ getHeight() + 4, s);
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
            if(bucketMilk.getStage() == null && getStage() != null){
                getStage().addActor(bucketMilk);
            }
        }
    }
}
