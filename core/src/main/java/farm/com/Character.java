package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Character extends MyActor{
    int speed = 2;
    Master game;
    Character(float x, float y, Stage s,Master game) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("farmer.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
        this.game = game;
    }

    @Override
    public void act(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(speed != 0){
                speed = -2;
            }
            moveBy(speed,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(speed != 0){
                speed = 2;
            }
            moveBy(speed,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(speed != 0){
                speed = 2;
            }

            moveBy(0,speed);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            speed = -2;
            moveBy(0,speed);
        }
        if(getBound().overlaps(Master.home.getBound())) {
            speed = 0;
            moveBy(speed,speed);
        }
    }
}
