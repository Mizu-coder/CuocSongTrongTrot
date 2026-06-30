package farm.com.seeds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import farm.com.*;
import farm.com.animals.Chicken;
import farm.com.animals.Cow;
import farm.com.animals.Pig;
import farm.com.enums.ChooseType;
import farm.com.enums.NV;
import farm.com.enums.PlantType;
import farm.com.enums.Text;
import farm.com.screens.GameScreen;
import farm.com.screens.Master;
import farm.com.soilpaddy.*;

public class Plants extends MyActor {
    Master game;
    public float time;
    Animation<TextureRegion> animation;
    public PlantType plantType = PlantType.PUMKIN;
    ShowInfo infoSeed;
    Text text = Text.GIEO;
    NV nv = NV.NOTHING;

    R1 r1;
    R2 r2;
    R3 r3;
    R4 r4;
    SoilP soilP;

    public Plants(float x, float y, Stage s, Master game, float time) {
        super(x, y, s);
        this.game = game;
        int seed = MathUtils.random(5, 10);
        int seedp = MathUtils.random(10,20);
        infoSeed = new ShowInfo(getX(), getY() + getHeight() + 4, getStage(), "" + seed, 10);
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
        if(Master.type.equals(ChooseType.PADDY)){
            plantType = PlantType.PADDY;
            TextureRegion[] frames = new TextureRegion[21];
            frames[0] =new TextureRegion(new Texture("ruong.jpg")) ;
            frames[1] = new TextureRegion(new Texture("ruong.jpg"));
            frames[2] = new TextureRegion(new Texture("ruong.jpg"));
            frames[3] = new TextureRegion(new Texture("ruong.jpg"));
            frames[4] = new TextureRegion(new Texture("ruong.jpg"));
            frames[5] = new TextureRegion(new Texture("ruong2.png"));
            frames[6] = new TextureRegion(new Texture("ruong2.png"));
            frames[7] = new TextureRegion(new Texture("ruong2.png"));
            frames[8] = new TextureRegion(new Texture("ruong2.png"));
            frames[9] = new TextureRegion(new Texture("ruong2.png"));
            frames[10] = new TextureRegion(new Texture("ruong3.png"));
            frames[11] = new TextureRegion(new Texture("ruong3.png"));
            frames[12] = new TextureRegion(new Texture("ruong3.png"));
            frames[13] = new TextureRegion(new Texture("ruong3.png"));
            frames[14] = new TextureRegion(new Texture("ruong3.png"));
            frames[15] = new TextureRegion(new Texture("ruong4.png"));
            frames[16] = new TextureRegion(new Texture("ruong4.png"));
            frames[17] = new TextureRegion(new Texture("ruong4.png"));
            frames[18] = new TextureRegion(new Texture("ruong4.png"));
            frames[19] = new TextureRegion(new Texture("ruong4.png"));
            frames[20] = new TextureRegion(new Texture("ruong5.png"));
            animation = new Animation<TextureRegion>(0.01f, frames);
        }



        this.time = time;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);

        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                if (game.sun < 3 && game.rai < 3) {
                    if (Master.type.equals(ChooseType.WATER)) {
                        game.wateringCan.time = 1;
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
                    if(animation.isAnimationFinished(Plants.this.time)){
                        switch (plantType){
                            case PUMKIN -> {
                                text = Text.COMPLETE;
                                GameState.seedpu += seed;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                GameScreen.complete += 1;
                                switch (text){
                                    case COMPLETE -> {
                                        if(Master.nvb){
                                            GameState.money += 600;
                                            GameScreen.chickens.add(new Chicken(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.cows.add(new Cow(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.pigs.add(new Pig(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            text = Text.NOTHING;
                                            Master.finger.remove();
                                            Master.nvb = false;
                                        }
                                    }
                                }
                                Master.misson.thuongCay();

                                remove();
                            }
                            case CARROT -> {
                                text = Text.COMPLETE;
                                GameState.seedc += seed;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                GameScreen.complete += 1;
                                switch (text){
                                    case COMPLETE -> {
                                        if(Master.nvb){
                                            GameState.money += 600;
                                            GameScreen.chickens.add(new Chicken(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.cows.add(new Cow(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.pigs.add(new Pig(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            text = Text.NOTHING;
                                            Master.finger.remove();
                                            Master.nvb = false;
                                        }
                                    }
                                }
                                Master.misson.thuongCay();
                                remove();
                            }
                            case POTATO -> {
                                text = Text.COMPLETE;
                                GameState.seedp += seed;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                GameScreen.complete += 1;
                                switch (text){
                                    case COMPLETE -> {
                                        if(Master.nvb){
                                            GameState.money += 600;
                                            GameScreen.chickens.add(new Chicken(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.cows.add(new Cow(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.pigs.add(new Pig(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            text = Text.NOTHING;
                                            Master.finger.remove();
                                            Master.nvb = false;
                                        }
                                    }
                                }
                                Master.misson.thuongCay();
                                remove();
                            }
                            case TOMATO -> {
                                text = Text.COMPLETE;
                                GameState.seedt += seed;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                GameScreen.complete += 1;
                                switch (text){
                                    case COMPLETE -> {
                                        if(Master.nvb){
                                            GameState.money += 600;
                                            GameScreen.chickens.add(new Chicken(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.cows.add(new Cow(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.pigs.add(new Pig(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            text = Text.NOTHING;
                                            Master.finger.remove();
                                            Master.nvb = false;
                                        }
                                    }
                                }
                                Master.misson.thuongCay();
                                remove();
                            }
                            case BEAN -> {
                                text = Text.COMPLETE;
                                GameState.seedb += seed;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                GameScreen.complete += 1;
                                switch (text){
                                    case COMPLETE -> {
                                        if(Master.nvb){
                                            GameState.money += 600;
                                            GameScreen.chickens.add(new Chicken(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.cows.add(new Cow(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            GameScreen.pigs.add(new Pig(MathUtils.random(50, Gdx.graphics.getWidth()), MathUtils.random(50, Gdx.graphics.getHeight()), getStage()));
                                            text = Text.NOTHING;
                                            Master.finger.remove();
                                            Master.nvb = false;
                                        }
                                    }
                                }
                                Master.misson.thuongCay();
                                remove();
                            }
                            case PADDY -> {
                                GameState.seedpa += seedp;
                                infoSeed.fadeOut();
                                GameScreen.listPlants.removeValue(Plants.this, true);
                                GameScreen.complete += 5;
                                Master.misson.thuongCay();
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

    @Override
    public String toString() {
        String info = "";
        switch (plantType){
            case PUMKIN -> {
                info = "Bí ngô, thu hoạch quả";
            }
            case POTATO -> {
                info = "Khoai tây, thu hoạch củ";
            }
            case CARROT -> {
                info = "Cà rốt, thu hoạch củ";
            }
            case TOMATO -> {
                info = "Cà chua, thu hoạch quả";
            }
            case BEAN -> {
                info = "Đỗ, thu hoạch quả";
            }
        }
        return info;
    }
}
