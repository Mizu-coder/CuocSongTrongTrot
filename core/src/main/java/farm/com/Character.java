package farm.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import farm.com.enums.Place;
import farm.com.screens.Master;


public class Character extends MyActor{

    Master game;
    int man_speed = 2;
    float man_speedw = 0.5f;

    public Animation<TextureRegion> animationLeft, animationRight, animationUp, animationDown, animationDie, animationWin;
    private float time;
    TextureRegion textureRegionSitting;

    public Character(float x, float y, Stage s,Master game) {
        super(x, y, s);
        this.game = game;
        game.chai = false;

        textureRegionSitting = new TextureRegion(new Texture("sitting.png"));
        Texture texture = new Texture("man1.png");

        TextureRegion[] frames = splitTexture(texture, 5, 4);

        animationLeft = createAnimation(0.1f, frames[10], frames[11], frames[12], frames[13], frames[14]);
        animationDown = createAnimation(0.1f, frames[0], frames[1], frames[2], frames[3], frames[4]);
        animationRight = createAnimation(0.1f,  frames[15], frames[16], frames[17], frames[18], frames[19]);
        animationUp = createAnimation(0.1f,  frames[5], frames[6], frames[7], frames[8], frames[9]);

        setSize(texture.getWidth()/5, texture.getHeight()/4);
        textureRegion = animationRight.getKeyFrame(0);
    }

    @Override
    public void act(float delta) {
        game.wa = false;
        float speedX = 0;
        float speedY = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
            man_speed = 4;
        }else{
            man_speed = 2;
        }
        if(getBound().overlaps(Master.water.getBound()) || getBound().overlaps(Master.water2.getBound())||getBound().overlaps(Master.waterL.getBound())|| getBound().overlaps(Master.waterR.getBound())|| getBound().overlaps(Master.waterLU.getBound())|| getBound().overlaps(Master.waterDoc.getBound())){
            game.wa = true;
        }
        if(game.wa){
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                speedX = -man_speedw;
                speedY = 0;
                textureRegion = animationLeft.getKeyFrame(time += delta);
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                speedX = man_speedw;
                speedY = 0;
                textureRegion = animationRight.getKeyFrame(time += delta);
            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                speedX = 0;
                speedY = -man_speedw;
                textureRegion = animationDown.getKeyFrame(time += delta);
            } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                speedX = 0;
                speedY = man_speedw;
                textureRegion = animationUp.getKeyFrame(time += delta);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
                man_speedw = 0f;
            }else{
                man_speed = 0;
            }
        }
        if(!game.wa) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                speedX = -man_speed;
                speedY = 0;
                textureRegion = animationLeft.getKeyFrame(time += delta);
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                speedX = man_speed;
                speedY = 0;
                textureRegion = animationRight.getKeyFrame(time += delta);
            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                speedX = 0;
                speedY = -man_speed;
                textureRegion = animationDown.getKeyFrame(time += delta);
            } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                speedX = 0;
                speedY = man_speed;
                textureRegion = animationUp.getKeyFrame(time += delta);
            }
        }
        moveBy(speedX, speedY);
        if (collision() || game.chai) {
            moveBy(-speedX, -speedY);
        }
        if (game.chai) {
            setPosition(527, 379);
            textureRegion = textureRegionSitting;
        }
        if (game.chai && Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            setPosition(777, 412);
            textureRegion = animationRight.getKeyFrame(time += delta);
            game.chai = false;
        }
    }
    public boolean collision(){
        if(Place.FARM.equals(game.place)) {
            if (getBound().overlaps(Master.home.getBound())) {
                return true;
            }
            for (Cage c : game.gameScreen.cages) {
                if (getBound().overlaps(c.getBound())) {
                    return true;
                }
            }
            if (getBound().overlaps(Master.tree.getBound())) {
                return true;
            }

            if (getBound().overlaps(Master.well.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.lake.getBound())) {
                return true;
            }
            if (getBound().overlaps(game.loAp.getBound())) {
                return true;
            }
            if(getBound().overlaps(Master.windmills.getBound())){
                return true;
            }
        }

        if(Place.INHOME.equals(game.place)) {
            if (getBound().overlaps(Master.bed.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.tv.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.heater.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.sofa.getBound())) {
                game.chai = true;
                return true;
            }
            if (getBound().overlaps(Master.wallLeft.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.wallDL.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.wallDR.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.wallright.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.wallup.getBound())) {
                return true;
            }
            if (getBound().overlaps(Master.sensor.getBound())) {
                game.setScreen(game.gameScreen);
                setPosition(game.sofa.getX(), game.sofa.getY());
                return true;
            }
        }
        return false;
    }

    private Animation<TextureRegion> createAnimation(float frameDuration, TextureRegion... regions) {
        Animation<TextureRegion> anim = new Animation<>(frameDuration, regions);
        anim.setPlayMode(Animation.PlayMode.LOOP);
        return anim;
    }

    private TextureRegion[] splitTexture(Texture texture, int cols, int rows) {
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth() / cols, texture.getHeight() / rows);
        TextureRegion[] frames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                frames[index++] = tmp[i][j];
        return frames;
    }
}
