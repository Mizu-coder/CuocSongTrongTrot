package farm.com.animals;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.EnergyBar;
import farm.com.GameState;
import farm.com.ShowInfo;
import farm.com.enums.AnimalNames;
import farm.com.screens.Master;
import farm.com.Utils;

public class Pig extends AnimalActor {
    float time;
    Animation<TextureRegion> animation;
    Animation<TextureRegion> animationBig;
    Master game;
    GameState gameState;

    public Pig(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        name = AnimalNames.PIG;
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
                    if(age > 5){
                        GameState.totalPork += meat;
                        infoMeat.remove();
                        new ShowInfo(getX() + getWidth() + 4, getY() + getHeight() + 4, s, "+ 1 " +" kg meat", 8).fadeOut();

                        energyBar.remove();
                        remove();
                    }
                }
            });

        infoMeat = new ShowInfo(getX() + getWidth() + 4, getY() + getHeight() + 4, s, "+" + "meat", 8);
        infoMeat.remove();


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
        if(age > 5){
            if(infoMeat.getStage() == null){
                getStage().addActor(infoMeat);
            }
        }

    }

}




