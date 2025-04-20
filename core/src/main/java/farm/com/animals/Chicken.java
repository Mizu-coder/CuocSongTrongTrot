package farm.com.animals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.EnergyBar;
import farm.com.GameState;
import farm.com.ShowInfo;
import farm.com.enums.AnimalNames;
import farm.com.screens.GameScreen;
import farm.com.screens.Master;
import farm.com.Utils;

public class Chicken extends AnimalActor {
    float time;
    Animation<TextureRegion> animation;
    Master game;
    GameScreen gameScreen;
    Egg egg;
    public Chicken(float x, float y, Stage s, Master game) {
        super(x, y, s);
        TextureRegion[] frames = new TextureRegion[2];
        this.game = game;
        name = AnimalNames.CHICKEN;
        gameScreen = new GameScreen(game);
        frames[0] = Utils.chic(0,0,8,8);
        frames[1] = Utils.chic(8,0,8,8);
        animation = new Animation<>(0.5f, frames);
        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);

        energyBar = new EnergyBar(getX(), getY() + getHeight() + 4, s);
        minusEnerGy = 1f/60;
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
                        GameState.egg++;
                        egg.remove();
                        energyBar.remove();
                        age = 1;
                        new ShowInfo(getX()+ getWidth() +4,  getY()+ getHeight() + 4, s, "+1 egg", 8).fadeOut();
                    }
                }
            });

            egg = new Egg(getX()+ getWidth() - 2, getY() + getHeight() - 8, getStage());
            egg.remove();
        }


    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        textureRegion = animation.getKeyFrame(time);
        if(age >= 3){
            textureRegion = Utils.chike(8,0,8,8);
            if(egg.getStage() == null){
                getStage().addActor(egg);
            }
        }

    }
}
