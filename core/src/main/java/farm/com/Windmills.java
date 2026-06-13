package farm.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Windmills extends MyActor{
    Animation<TextureRegion> animation;
    float time = 0;
    public Windmills(float x, float y, Stage s){
        super(x,y,s);
        TextureRegion[] frames = new TextureRegion[5];
        frames[0] = Utils.xoay(0,0,1360/5,600);
        frames[1] = Utils.xoay(1360/5,0,1360/5,600);
        frames[2] = Utils.xoay(2*1360/5,0,1360/5,600);
        frames[3] = Utils.xoay(3*1360/5,0,1360/5,600);
        frames[4] = Utils.xoay(4*1360/5,0,1360/5,600);
        animation = new Animation<TextureRegion>(0.5f,frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        textureRegion = animation.getKeyFrame(time);
        setSize(textureRegion.getRegionWidth()/2f, textureRegion.getRegionHeight()/2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        textureRegion = animation.getKeyFrame(time);
    }
}
