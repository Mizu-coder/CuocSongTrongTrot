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
import farm.com.enums.ChooseType;
import farm.com.screens.GameScreen;
import farm.com.screens.Master;
import farm.com.Utils;

public class Chicken extends AnimalActor {
    float time;
    Animation<TextureRegion> animation;
    Egg egg;
    public Chicken(float x, float y, Stage s) {
        super(x, y, s);
        TextureRegion[] frames = new TextureRegion[2];
        name = AnimalNames.CHICKEN;
        Master.sohieu = 3;
        frames[0] = Utils.chic(0,0,8,8);
        frames[1] = Utils.chic(8,0,8,8);
        animation = new Animation<>(0.5f, frames);
        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*4,textureRegion.getRegionHeight()*4);

        energyBar = new EnergyBar(getX(), getY() + getHeight() + 4, s);
        minusEnerGy = 1f/(180/3);
            addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                    if(ill && Master.type.equals(ChooseType.KIMTIEM) && GameState.soKimTiem > 0){
                        ill = false;
                        GameState.soKimTiem--;
                    }
                    feed();
                }
            });

            egg = new Egg(getX()+ getWidth() - 2, getY() + getHeight() - 8, this);
        }


    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        textureRegion = animation.getKeyFrame(time);
        if(age >= 3){
            textureRegion = Utils.chike(8,0,8,8);
        }
        if(age >= 5){
            if(egg.getStage() == null && getStage() != null){
                getStage().addActor(egg);
            }
        }

    }
}
