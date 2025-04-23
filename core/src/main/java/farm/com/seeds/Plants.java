package farm.com.seeds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.GameState;
import farm.com.MyActor;
import farm.com.ShowInfo;
import farm.com.Utils;
import farm.com.enums.ChooseType;
import farm.com.enums.PlantType;
import farm.com.screens.GameScreen;
import farm.com.screens.Master;

public class Plants extends MyActor {
    Master game;
    public float time;
    boolean isWatered = false;
    Animation<TextureRegion> animation;
    public PlantType plantType = PlantType.PUMKIN;
    ShowInfo infoSeed;
    public Plants(float x, float y, Stage s, Master game, float time) {
        super(x, y, s);
        this.game = game;
        infoSeed = new ShowInfo(getX(), getY() + getHeight() + 4, getStage(), "" + (int)GameState.seedpu, 10);
        infoSeed.remove();

        if (Master.type.equals(ChooseType.PUMKIN)) {
            plantType = PlantType.PUMKIN;
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 0, 16, 16);
            frames[1] = Utils.getRegionPlants(16, 0, 16, 16);
            frames[2] = Utils.getRegionPlants(32, 0, 16, 16);
            frames[3] = Utils.getRegionPlants(48, 0, 16, 16);
            frames[4] = Utils.getRegionPlants(64, 0, 16, 16);
            animation = new Animation<TextureRegion>(0.01f,frames);
        }
        if (Master.type.equals(ChooseType.CAROT)) {
            plantType = PlantType.CARROT;
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 16, 16, 16);
            frames[1] = Utils.getRegionPlants(16, 16, 16, 16);
            frames[2] = Utils.getRegionPlants(16 * 2, 16, 16, 16);
            frames[3] = Utils.getRegionPlants(16 * 3, 16, 16, 16);
            frames[4] = Utils.getRegionPlants(16 * 4, 16, 16, 16);
            animation = new Animation<TextureRegion>(0.01f, frames);
        }
        if (Master.type.equals(ChooseType.POTATO)) {
            plantType = PlantType.POTATO;
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 16 * 2, 16, 16);
            frames[1] = Utils.getRegionPlants(16, 16 * 2, 16, 16);
            frames[2] = Utils.getRegionPlants(16 * 2, 16 * 2, 16, 16);
            frames[3] = Utils.getRegionPlants(16 * 3, 16 * 2, 16, 16);
            frames[4] = Utils.getRegionPlants(16 * 4, 16 * 2, 16, 16);
            animation = new Animation<TextureRegion>(0.01f, frames);
        }
        if (Master.type.equals(ChooseType.TOMATO)) {
            plantType = PlantType.TOMATO;
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 16 * 3, 16, 16);
            frames[1] = Utils.getRegionPlants(16, 16 * 3, 16, 16);
            frames[2] = Utils.getRegionPlants(16 * 2, 16 * 3, 16, 16);
            frames[3] = Utils.getRegionPlants(16 * 3, 16 * 3, 16, 16);
            frames[4] = Utils.getRegionPlants(16 * 4, 16 * 3, 16, 16);
            animation = new Animation<TextureRegion>(0.01f, frames);
        }
        if (Master.type.equals(ChooseType.BEAN)) {
            plantType = PlantType.BEAN;
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 16 * 4, 16, 16 * 3);
            frames[1] = Utils.getRegionPlants(16, 16 * 4, 16, 16 * 3);
            frames[2] = Utils.getRegionPlants(16 * 2, 16 * 4, 16, 16 * 3);
            frames[3] = Utils.getRegionPlants(16 * 3, 16 * 4, 16, 16 * 3);
            frames[4] = Utils.getRegionPlants(16 * 4, 16 * 4, 16, 16 * 3);
            animation = new Animation<TextureRegion>(0.01f, frames);
        }


        this.time = time;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);

        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                if (game.sun < 3 && game.rai < 3) {
                    if (game.water) {
                        isWatered = true;
                        game.water = false;
                        addAction(Actions.sequence(
                            Actions.delay(1),
                            Actions.run(
                                () -> {
                                    Plants.this.time += Gdx.graphics.getDeltaTime();
                                    textureRegion = animation.getKeyFrame(Plants.this.time);
                                }
                            )
                        ));
                    }
                    if(animation.isAnimationFinished(time)){
                        switch (plantType){
                            case PUMKIN -> {
                                GameState.seedpu += 3;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                remove();
                            }
                            case CARROT -> {
                                GameState.seedc += 2;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                remove();
                            }
                            case POTATO -> {
                                GameState.seedp += 5;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                remove();
                            }
                            case TOMATO -> {
                                GameState.seedt += 5;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                remove();
                            }
                            case BEAN -> {
                                GameState.seedb += 6;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                remove();
                            }
                        }

                    }
                }

            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(animation.isAnimationFinished(time)){
            if(infoSeed.getStage() == null){
                getStage().addActor(infoSeed);
                infoSeed.setPosition(getX()+ getWidth() - 2, getY() + getHeight() - 8);
            }
        }
    }
}
