package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Character extends MyActor{
    Direction direction = Direction.RIGHT;
    float time;

    Master game;
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    Character(float x, float y, Stage s,Master game) {
        super(x, y, s);
        Texture texture =new Texture("character.png");
        this.game = game;
        int cot = 16;
        int hang = 1;
        TextureRegion[][] frameBuff = TextureRegion.split(texture, texture.getWidth() / cot, texture.getHeight() / hang);

        TextureRegion[] frames = new TextureRegion[cot * hang];
        int index = 0;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                frames[index++] = frameBuff[i][j];
            }
        }
        TextureRegion[] framesDown = {frames[0], frames[1], frames[2], frames[3]};
        TextureRegion[] framesLeft = {frames[4], frames[5], frames[6], frames[7]};
        TextureRegion[] framesRight = {frames[8], frames[9], frames[10], frames[11]};
        TextureRegion[] framesUp = {frames[12], frames[13], frames[14], frames[15]};

        animationLeft = new Animation<TextureRegion>(0.1f, framesLeft);
        animationRight = new Animation<TextureRegion>(0.1f, framesRight);
        animationDown = new Animation<TextureRegion>(0.1f, framesDown);
        animationUp = new Animation<TextureRegion>(0.1f, framesUp);

        animationLeft.setPlayMode(Animation.PlayMode.LOOP);
        animationRight.setPlayMode(Animation.PlayMode.LOOP);
        animationUp.setPlayMode(Animation.PlayMode.LOOP);
        animationDown.setPlayMode(Animation.PlayMode.LOOP);

        time = 0;
        textureRegion = animationRight.getKeyFrame(time);

        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
    }

    @Override
    public void act(float delta) {
        int speedX = 0;
        int speedY = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            direction = Direction.LEFT;
            speedX = -2;
            speedY = 0;
            time += delta;
            textureRegion = animationLeft.getKeyFrame(time);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
           speedX = 2;
           speedY = 0;
           time += delta;
           textureRegion = animationRight.getKeyFrame(time);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            speedX = 0;
            speedY = 2;
            time += delta;
            textureRegion = animationUp.getKeyFrame(time);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            speedX = 0;
            speedY = -2;
            time += delta;
            textureRegion = animationDown.getKeyFrame(time);

        }
//        time += delta;
//        if(direction.equals(Direction.DOWN) || direction.equals(Direction.UP)){
//            direction = Direction.RIGHT;
//        }
//        if(getX() == 32){
//            direction = Direction.RIGHT;
//        }
//        if(getX() == Gdx.graphics.getWidth() - 32){
//            direction = Direction.LEFT;
//        }
//        if(direction.equals(Direction.RIGHT)){
//            moveBy(0.5f,0);
//            setScaleX(1);
//        }
//        if(direction.equals(Direction.LEFT)){
//            moveBy(-0.5f,0);
//            setScaleX(-1);
//        }

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
