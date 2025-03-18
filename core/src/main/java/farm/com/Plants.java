package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Plants extends MyActor{
    Master game;
    float time;
    Animation<TextureRegion> animation;
    Plants(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        if (game.type == 1) {
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 0, 16, 16);
            frames[1] = Utils.getRegionPlants(16, 0, 16, 16);
            frames[2] = Utils.getRegionPlants(32, 0, 16, 16);
            frames[3] = Utils.getRegionPlants(48, 0, 16, 16);
            frames[4] = Utils.getRegionPlants(64, 0, 16, 16);
            animation = new Animation<TextureRegion>(0.01f,frames);
        }
        if (game.type == 2) {
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 16, 16, 16);
            frames[1] = Utils.getRegionPlants(16, 16, 16, 16);
            frames[2] = Utils.getRegionPlants(16 * 2, 16, 16, 16);
            frames[3] = Utils.getRegionPlants(16 * 3, 16, 16, 16);
            frames[4] = Utils.getRegionPlants(16 * 4, 16, 16, 16);
            animation = new Animation<TextureRegion>(0.01f, frames);
        }
        if (game.type == 3) {
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 16 * 2, 16, 16);
            frames[1] = Utils.getRegionPlants(16, 16 * 2, 16, 16);
            frames[2] = Utils.getRegionPlants(16 * 2, 16 * 2, 16, 16);
            frames[3] = Utils.getRegionPlants(16 * 3, 16 * 2, 16, 16);
            frames[4] = Utils.getRegionPlants(16 * 4, 16 * 2, 16, 16);
            animation = new Animation<TextureRegion>(0.01f, frames);
        }
        if (game.type == 4) {
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 16 * 3, 16, 16);
            frames[1] = Utils.getRegionPlants(16, 16 * 3, 16, 16);
            frames[2] = Utils.getRegionPlants(16 * 2, 16 * 3, 16, 16);
            frames[3] = Utils.getRegionPlants(16 * 3, 16 * 3, 16, 16);
            frames[4] = Utils.getRegionPlants(16 * 4, 16 * 3, 16, 16);
            animation = new Animation<TextureRegion>(0.01f, frames);
        }
        if (game.type == 5) {
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0, 16 * 4, 16, 16 * 3);
            frames[1] = Utils.getRegionPlants(16, 16 * 4, 16, 16 * 3);
            frames[2] = Utils.getRegionPlants(16 * 2, 16 * 4, 16, 16 * 3);
            frames[3] = Utils.getRegionPlants(16 * 3, 16 * 4, 16, 16 * 3);
            frames[4] = Utils.getRegionPlants(16 * 4, 16 * 4, 16, 16 * 3);
            animation = new Animation<TextureRegion>(0.01f, frames);
        }


        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);

        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                if(game.type == 1){
                    if(game.water == 1){
                        time += Gdx.graphics.getDeltaTime();
                        textureRegion = animation.getKeyFrame(time);
                    }
                }
                if(game.type == 2){
                    if(game.water == 2){
                        time += Gdx.graphics.getDeltaTime();
                        textureRegion = animation.getKeyFrame(time);
                    }
                }
                if(game.type == 3){
                    if(game.water == 3){
                        time += Gdx.graphics.getDeltaTime();
                        textureRegion = animation.getKeyFrame(time);
                    }
                }
                if(game.type == 4){
                    if(game.water == 4){
                        time += Gdx.graphics.getDeltaTime();
                        textureRegion = animation.getKeyFrame(time);
                    }
                }
                if(game.type == 5){
                    if(game.water == 5){
                        time += Gdx.graphics.getDeltaTime();
                        textureRegion = animation.getKeyFrame(time);
                    }
                }

            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }
}
