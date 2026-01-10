package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.screens.Master;


public class Character extends MyActor{

    Master game;
    public Character(float x, float y, Stage s,Master game) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("farmer.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
        this.game = game;
    }

    @Override
    public void act(float delta) {
        int speedX = 0;
        int speedY = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                textureRegion = new TextureRegion(new Texture("farmer2.png"));
                speedX = -4;
                speedY = 0;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                textureRegion = new TextureRegion(new Texture("farmer3.png"));
                speedX = 4;
                speedY = 0;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                textureRegion = new TextureRegion(new Texture("farmer1.png"));
                speedX = 0;
                speedY = 4;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                textureRegion = new TextureRegion(new Texture("farmer.png"));
                speedX = 0;
                speedY = -4;
            }
        }else{
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                textureRegion = new TextureRegion(new Texture("farmer2.png"));
                speedX = -2;
                speedY = 0;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                textureRegion = new TextureRegion(new Texture("farmer3.png"));
                speedX = 2;
                speedY = 0;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                textureRegion = new TextureRegion(new Texture("farmer1.png"));
                speedX = 0;
                speedY = 2;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                textureRegion = new TextureRegion(new Texture("farmer.png"));
                speedX = 0;
                speedY = -2;
            }
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
        for (Cage c: game.gameScreen.cages){
            if(getBound().overlaps(c.getBound())) {
                return true;
            }
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
