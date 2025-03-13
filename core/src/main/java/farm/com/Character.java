package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Character extends MyActor{

    Master game;
    Character(float x, float y, Stage s,Master game) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("farmer.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
        this.game = game;
    }

    @Override
    public void act(float delta) {
        int speedX = 0;
        int speedY = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
           speedX = -2;
           speedY = 0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
           speedX = 2;
           speedY = 0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            speedX = 0;
            speedY = 2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            speedX = 0;
            speedY = -2;
        }
        moveBy(speedX, speedY);
        if(collision()){
            moveBy(-speedX,-speedY);
        }

    }
    public boolean collision(){
        if(getBound().overlaps(Master.home.getBound())) {
            return true;
        }
        if(getBound().overlaps(Master.tree.getBound())) {
            return true;
        }
        if(getBound().overlaps(Master.well.getBound())) {
            return true;
        }
        if(getBound().overlaps(Master.lake.getBound())) {
            return true;
        }
        return false;
    }
}
