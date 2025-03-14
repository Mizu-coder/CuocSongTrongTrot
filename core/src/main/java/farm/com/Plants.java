package farm.com;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Plants extends MyActor{
    Master game;
    float time;
    Animation<TextureRegion> animation;
    Plants(float x, float y, Stage s, Master game) {
        super(x, y, s);
        this.game = game;
        if(game.type == 1){
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0,0,16,16);
            frames[1] = Utils.getRegionPlants(16,0,16,16);
            frames[2] = Utils.getRegionPlants(32,0,16,16);
            frames[3] = Utils.getRegionPlants(48,0,16,16);
            frames[4] = Utils.getRegionPlants(64,0,16,16);

            animation = new Animation<TextureRegion>(0.5f, frames);
        }
        if(game.type == 2){
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0,16,16,16);
            frames[1] = Utils.getRegionPlants(16,16,16,16);
            frames[2] = Utils.getRegionPlants(16*2,16,16,16);
            frames[3] = Utils.getRegionPlants(16*3,16,16,16);
            frames[4] = Utils.getRegionPlants(16*4,16,16,16);
            animation = new Animation<TextureRegion>(0.5f, frames);
        }
        if(game.type == 3){
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0,16*2,16,16);
            frames[1] = Utils.getRegionPlants(16,16*2,16,16);
            frames[2] = Utils.getRegionPlants(16*2,16*2,16,16);
            frames[3] = Utils.getRegionPlants(16*3,16*2,16,16);
            frames[4] = Utils.getRegionPlants(16*4,16*2,16,16);
            animation = new Animation<TextureRegion>(0.5f, frames);
        }
        if(game.type == 4){
            TextureRegion[] frames = new TextureRegion[5];
            frames[0] = Utils.getRegionPlants(0,16*3,16,16);
            frames[1] = Utils.getRegionPlants(16,16*3,16,16);
            frames[2] = Utils.getRegionPlants(16*2,16*3,16,16);
            frames[3] = Utils.getRegionPlants(16*3,16*3,16,16);
            frames[4] = Utils.getRegionPlants(16*4,16*3,16,16);
            animation = new Animation<TextureRegion>(0.5f, frames);
        }

        time = 0;
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        textureRegion = animation.getKeyFrame(time);
    }
}
